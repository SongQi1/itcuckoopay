// 设置jqgrid的样式
$.jgrid.defaults.styleUI = 'Bootstrap';

/**
 * 弹出框
 * @type {{open: Dialog.open, openByUrl: Dialog.openByUrl, openUrl: Dialog.openUrl, alert: Dialog.alert, confirm: Dialog.confirm, msg: Dialog.msg}}
 */
var Dialog = {
    /**
     * 打开一个弹出窗口
     * @param title 必须。窗口名称
     * @param content 必须。窗口内容。任意的文本或html或dom元素
     * @param options 可选。其他layer参数
     */
    open: function (title, content, options) {
        options = $.extend({
            type: 1,
            shadeClose: false,
            title: title,
            content: content
        }, options);

        layer.open(options);
    },
    /**
     * 根据URL打开一个弹出窗口
     * @param title 必须。窗口名称
     * @param url 必须。URL，需返回HTML片段，而不是完整的HTML内容
     * @param options 可选。其他layer参数
     */
    openByUrl: function (title, url, options) {
        $.post(url, {}, function (data) {
            Dialog.open(title, data, options);
        }, 'html');
    },
    /**
     * 打开一个弹出窗口
     * @param title 必须。窗口名称
     * @param url 必须。URL，需返回HTML内容，如果返回的是HTML片段，请使用openByUrl方法
     * @param options 可选。其他layer参数
     */
    openUrl: function (title, url, options) {
        options = $.extend({
            type: 2,
            shadeClose: false,
            title: title,
            content: url
        }, options);

        layer.open(options);
    },
    /**
     * 警告框
     * @param message 必须。提示信息
     * @param okFn 可选。点击确定的回调函数
     * @param options 可选。其他layer参数
     */
    alert: function (message, okFn, options) {
        options = $.extend({
            icon: 2,
            title: '系统提示'
        }, options);

        layer.alert(message, options, function (index) {
            if (okFn) {
                okFn();
            }
            layer.close(index);
        });
    },
    /**
     * 操作确认框
     * @param message 必须。提示信息
     * @param okFn 可选。点击确定的回调函数
     * @param options 可选。其他layer参数
     */
    confirm: function (message, okFn, options) {
        options = $.extend({
            icon: 3,
            title: '操作提示'
        }, options);

        layer.confirm(message, options, function (index) {
            if (okFn) {
                okFn();
            }
            layer.close(index);
        });
    },
    /**
     * 提示操作框
     * @param title 必须。提示信息
     * @param content 必须。操作内容
     * @param okFn 可选。确定的的回调函数
     * @param options 可选。其他layer参数
     */
    prompt: function(title, content, okFn, options){
        options = $.extend({
            title: title,
            area: '400px',
            autoClose: true
        }, options);

        return layer.confirm(content, options, function(index){
            if(okFn){
                okFn();
            }
            if(options.autoClose) {
                layer.close(index);
            }
        });
    },
    /**
     * 提示框
     * @param message 必须。提示信息
     * @param endFn 可选。关闭的的回调函数
     * @param options 可选。其他layer参数
     */
    msg: function (message, endFn, options) {
        options = $.extend({
            // icon: 1,
            anim: 1,
            time: 1000
        }, options);

        layer.msg(message, options, function () {
            if (endFn) {
                endFn();
            }
        });
    },
    /**
     * 关闭Frame
     * @param frameName window的name
     */
    closeFrame: function (frameName) {
        var index = parent.layer.getFrameIndex(frameName); //获取窗口索引
        parent.layer.close(index);
    },

    /**
     * 设置dialog 宽度
     * @param offset 偏移量
     */
    width: function (fixHeight) {
        if (isNaN(fixHeight)) {
            fixHeight = 0;
        }

        return $(window).width() / 3 - fixHeight;
    },

    /**
     * 设置dialog 高度
     * @param offset
     * @returns {*}
     */
    height: function (fixHeight) {
        if (isNaN(fixHeight)) {
            fixHeight = 0;
        }
        return $(window).height() / 2 + fixHeight;
    }
};

var Page = {

    /**
     * 表单提交初始化方式
     * @param form 表单
     * @param options jqueryValidate参数, submitSuccess: 提交成功回调函数,submitFail：提交失败回调函数
     */
    validateForm: function (form, options) {
        form = $(form);
        options = $.extend({
            highlight: function (element) {
                if ($(element).closest("table").length > 0) {
                    var $this = $(element).closest("td");
                    $this.prev().removeClass("has-success").addClass("has-error");
                    $this.removeClass("has-success").addClass("has-error");
                } else {
                    $(element).closest(".form-group").removeClass("has-success").addClass("has-error");
                }
            },
            success: function (element,r) {
                layer.close($(element).attr("tipsIndex"));
                if ($(element).closest("table").length > 0) {
                    var $this = $(element).closest("td");
                    $this.removeClass("has-error").addClass("has-success");
                    $this.prev().removeClass("has-error").addClass("has-success");
                } else {
                    $(r).closest(".form-group").removeClass("has-error").addClass("has-success");
                }
            },
            errorElement: "span",
            errorPlacement: function (e, r) {
                layer.close($(r).attr("tipsIndex"));
                //console.log(e[0].innerText);
                if (e[0].innerText != ''){
                    $(r).attr("tipsIndex", layer.tips(e.text(), r, {
                        tips: [2, '#ffcc99'],
                        tipsMore: true,
                        time: 0
                    }));
                }else{
                    layer.close($(r).attr("tipsIndex"));
                }
            },
            errorClass: "help-block m-b-none",
            validClass: "m-b-none",
            // 默认提交方式
            submitHandler: function (_form) {
                if (form.valid()) {
                    var submitFn = function () {
                        Page.ajaxPOST(form.attr('action'), form.serialize(), options.submitSuccess, options.submitFail);
                    };
                    if (options.tips) { // 有提示信息
                        Dialog.confirm(options.tips, function () {
                            submitFn();
                        });
                    } else {
                        submitFn();
                    }
                }
            },
            // 提交成功
            submitSuccess: function (data) {
                Dialog.msg(data.msg);
            },
            // 提交失败
            submitFail: function (data) {
                Dialog.alert(data.msg ? data.msg : '操作失败！');
            }
        }, options);

        return form.validate(options);
    },


    /**
     * ajax请求
     * @param method 请求方法  GET / POST
     * @param url 请求URL
     * @param data 请求参数
     * @param successFn 成功回调函数
     * @param failFn 失败回调函数
     */
    ajax: function (method, url, data, successFn, failFn) {
        $.ajax({
            url: url,
            type: method,
            data: data,
            success: function (data) {
                if (data.code == "1") {
                    if (successFn) {
                        successFn(data);
                    } else {
                        Dialog.msg(data.msg); // 默认
                    }
                } else {
                    if (failFn) {
                        failFn(data);
                    } else {
                        Dialog.alert(data.msg); // 默认
                    }
                }
            },
            error: function (r) {
                Dialog.alert('服务器忙，请您稍后再试！');
            }
        });
    },
    /**
     * ajax  GET 请求
     * @param url
     * @param data
     * @param successFn
     * @param failFn
     */
    ajaxGET: function (url, data, successFn, failFn) {
        this.ajax('GET', url, data, successFn, failFn);
    },
    /**
     * ajax  POST 请求
     * @param url
     * @param data
     * @param successFn
     * @param failFn
     */
    ajaxPOST: function (url, data, successFn, failFn) {
        this.ajax('POST', url, data, successFn, failFn);
    }
};

var JSTree = {
    loading: function (jsTree, url, callback, options) {

        options = $.extend({
            multiple: false
        }, options);

        var jsTreeObj = $(jsTree);
        //清空树
        jsTreeObj.data('jstree', false).empty();

        //重新加载
        jsTreeObj.jstree({
            plugins: ["wholerow", "json_data"],
            core: {
                data: {
                    dataType: "json",
                    url: function (node) {
                        var _url = url.replace(/\{nodeId\}/g, (node && node.id == '#' ? '0' : node.id));

                        return _url + '&' + $('.tree-param').serialize();
                    }
                },
                multiple: options.multiple
            }
        }).on("dblclick.jstree", function () {
            var tree = $.jstree.reference(jsTree);
            var node = tree.get_selected(true);
            if (callback) {
                callback(tree, node);
            }
        });
    }
};


/**
 * 格式化类
 */
var Formatter = {
    Date: function (value, row, index) {
        return isNaN(value) ? value : $.formatDate("yyyy-MM-dd", new Date(value));
    },
    Currency: function (value, row, index) {
        return formatCurrency(value);
    },
    TaxRate: function (value, row, index) {
        return ((value && value != '' ? value : 0) / 100.0).toFixed(2) + '';
    },
    Price: function (value, row, index) {
        return Number(formatCurrency(value)).toFixed(12);
    },
    Amount: function (value, row, index) {
        return formatCurrency(value);//((value && value != '' ? value : 0) * 1).toFixed(2) + '';
    },
    Number: function (value, row, index) {
        return ((value && value != '' ? value : 0) * 1).toFixed(2) + '';
    },
    Remark: function (value, row, index) {
        return '<textarea id="invRemark' + row.id + '" style="display: none">' + value + '</textarea>'
            + '<a href="javascript:void(0);" onclick="clickRemark($(\'#invRemark' + row.id + '\').val())">查看备注</a>';
    },
    LongText: function (length, alertText, showText) {//例子:vendor/list.jsp[103]
        return function (value, options, row) {
            value = value || '';
            if (value == null || value.length <= length) {
                return value;
            }
            var alertText_ = alertText || value;
            var showText_ = showText || '......';
            alertText_ = typeof(alertText_) == 'function' ? alertText_(value, options, row) : alertText_;
            showText_ = typeof(showText_) == 'function' ? showText_(value, options, row) : showText_;
            var html = $('<label onclick="layer.alert(this.title,{shadeClose:true})">' + value.substring(0, length) + showText_ + '</label>');
            html.attr('title', alertText_);
            return html[0].outerHTML;
        };
    },
    showDesc: function (map, defvalue) { //例子:vendor/list.jsp[96,98]
        defvalue = defvalue || '';
        return function (value, options, row) {
            return map[value] ? map[value] : defvalue;
        }
    },
    aHref:function(hrefUrl,attr){ //表单指定字段增加a标签跳转 例子：资源维护
        attr = (attr == null) ? "id" : attr;
        return function(value, options, row){
            return "<a href='"+hrefUrl+"?"+attr+"="+row[attr]+"'>"+value+"</a>";
        }
    }
};


/**
 * ztree
 * @type {{init: ZTree.init}}
 */
var ZTree = {
    init: function (treeId, url, options) {
        options = $.extend({
            postData: {},
            clickTree: function (treeId, treeNode, clickFlag) {
            },
            getFirstNode: function (treeNode) {
            },
            dblClickTree: function (event, treeId, treeNode) {

            },
            check: {
                enable: true
            },
            view: {
                showLine: false,
                selectedMulti: false,
                nameIsHTML: true
            },
            data: {
                key: {
                    name: "text"
                },
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pId",
                    rootPId: "0"
                }
            }
        }, options);

        var setting = {
            check: options.check,
            view: options.view,
            data: options.data,
            callback: {
                beforeClick: function (treeId, treeNode, clickFlag) {
                    options.clickTree(treeId, treeNode, clickFlag);
                },
                onDblClick: function (event, treeId, treeNode) {
                    options.dblClickTree(event, treeId, treeNode);
                }
            }
        }
        if (typeof (url) == 'string') {
            Page.ajaxPOST(url, options.postData, function (data) {
                $.fn.zTree.init($("#" + treeId), setting, data.result);
                var zTree = $.fn.zTree.getZTreeObj(treeId);
                var rootnodes = zTree.getNodes();
                if (rootnodes[0] == undefined) {
                    return;
                }
                options.getFirstNode(rootnodes[0]);

            });
        }


        var operation = {
            add: function (nodes, pId, newNode, zTree) {
                $.each(nodes, function (i, obj) {
                    if (obj.id == pId) {
                        zTree.addNodes(nodes[i], newNode);
                        $.each(nodes[i].children, function (i, obj) {
                            if (obj.id == newNode.id) {
                                zTree.selectNode(obj);
                            }
                        })
                        options.clickTree(null, newNode, null);
                        return;
                    }
                    if (undefined != nodes[i].children) {
                        operation.add(nodes[i].children, pId, newNode, zTree);
                    }
                })
            },
            update: function (nodes, id, currentNode, zTree) {
                $.each(nodes, function (i, obj) {
                    if (obj.id == id) {
                        var node = nodes[i];
                        node.text = currentNode.text;
                        node.pId = currentNode.pId;
                        zTree.updateNode(node);
                        zTree.selectNode(node);
                        options.clickTree(null, node, null);
                        return;
                    }
                    if (undefined != nodes[i].children) {
                        operation.update(nodes[i].children, id, currentNode, zTree);
                    }
                })
            },
            remove: function (nodes, id, newNode, zTree) {
                for (var i = 0; i < nodes.length; i++){
                    if (nodes[i].id == id){
                        zTree.removeNode(nodes[i]);
                        // options.clickTree(null, nodes[i], null);
                        return;
                    }
                    if (nodes[i].children) {
                        operation.remove(nodes[i].children, id, newNode, zTree);
                    }
                }
            }
        };

        return {
            getOptions: options,
            getTreeObj: function () {
                return $.fn.zTree.getZTreeObj(treeId);
            },
            selectNodeIndex: function (index) {
                if (index >= 0) {
                    var nodes = this.getTreeObj().getNodes();
                    this.getTreeObj().checkNode(nodes[index]);
                }
            },
            getSelected: function (field) { // 指定返回指定field的值,，如 'id'
                var result = [];
                var selectedNodes = this.getTreeObj().getSelectedNodes();
                for (var i = 0; i < selectedNodes.length; i++) {
                    result.push(field ? selectedNodes[i][field] : selectedNodes[i])
                }
                return result;
            },
            addNode: function (newNode) {
                operation.add(this.getTreeObj().getNodes(), newNode.pId, newNode, this.getTreeObj());
            },
            updateTreeNode: function (currentNode) {
                operation.update(this.getTreeObj().getNodes(), currentNode.id, currentNode, this.getTreeObj());
            },
            removeNode: function (newNode) {//例子:vendor/list.jsp[192]
                operation.remove(this.getTreeObj().getNodes(), newNode.id, newNode, this.getTreeObj());
            },
        };
    }
};


/**
 * 详见 views/masterdata/companytree_table_demo.jsp
 * @type {{}}
 */
var TREE_TABLE = {
    init: function (url, table, tplId, options) {
        var operation = {
            addRow: function (list, tpl, data, pid, root) {
                for (var i = 0; i < data.length; i++) {
                    var row = data[i];
                    this.constantData(row);
                    if ((!row ? '' : !row[options.parentId] ? '' : row[options.parentId]) == pid) {
                        $(list).append(Mustache.render(tpl, {
                            pid: (root ? 0 : pid), row: row
                        }));
                        this.addRow(list, tpl, data, row.id);
                    }
                }
            },
            constantData: function (data) {
                for (var Key in data) {
                    $(options.constant).each(function (i, obj) {
                        var thisObj = obj[Key];
                        if (thisObj != undefined) {
                            var value = thisObj[data[Key]];
                            data[Key] = thisObj[value == undefined ? '-1' : data[Key]]
                        }
                    });
                }
            }
        }

        options = $.extend({
            //请求对象
            postDate: {},
            constant: {},
            parentId: 'parentId',

        }, options);
        var tpl = $(tplId).html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
        if (typeof (url) == 'string') {
            Page.ajaxPOST(url, options.postData, function (data) {
                operation.addRow(table + "List", tpl, data.result, 0, true);
                // 取消所有事件
                $(table).unbind('click mouseover mouseout');
                $(table).treeTable({expandLevel: 5});
            });
        }
        return {
            query: function (option) {
                option = $.extend({postDate: {}}, option)
                option.constant = options.constant;
                option.parentId = options.parentId;
                $(table + "List").html("");
                TREE_TABLE.init(url, table, tplId, option);
            }
        }
    }
};
/**
 * 查询类
 */
var Searcher = {
    /**
     * 创建查询器（根据规范来限制表单元素）
     * <pre>
     *   查询表单ID：jqGrid + 'Form'
     *   查询按钮ID：jqGrid + 'Button'
     *   分页条ID： jqGrid + 'Pager'
     * </pre>
     * @param jqGrid 必须。jqGrid对象
     * @param colModel 必须。展示的列表定义
     * @param options 可选。其他jqGrid参数, 如果为false，则不主动加载数据
     * @returns {{options, query: searcher.query, getSelectedRows: searcher.getSelectedRows}}
     */

    create: function (jqGrid, colModel, options) {
        var jqGridObject = $(jqGrid);
        var jqGridId = jqGridObject.attr('id');
        var searchForm = $('#' + jqGridId + 'Form');
        var searchButton = searchForm.find(':submit');
        var searchUrl = searchForm.attr('action');
        var rawData = null;
        var jqGridOptions = $.extend({
            url: searchUrl,
            mtype: 'POST',
            datatype: "json",
            height: 'auto',
            autowidth: true,
            shrinkToFit: true,
            rownumbers: true,//展现行号
            rowNum: 10,
            rowList: [10, 20, 30],
            /*jsonReader: {
             root:"records", page:"page", total:"total",          //   很重要 定义了 后台分页参数的名字。
             records:"total", repeatitems:false, id : "id"
             },*/
            colModel: colModel,
            pager: "#" + jqGridId + "Pager",
            viewrecords: true,
            caption: jqGridObject.attr('title'),
            multiselect: true, // 复选框
            hidegrid: false,
            postData: searchForm.serializeObject(),
            loadError: function () {
                Dialog.alert('数据加载失败！');
            },
            serializeGridData: function (data) {
                return data;
            },
            beforeProcessing: function (data) {
                if (data.success) {
                    rawData = data;
                    if (data.result.rows == undefined) {
                        data.rows = data.result;
                    } else {
                        for (var k in data.result) {
                            data[k] = data.result[k];
                        }
                    }

                    return true;
                } else {
                    if (data.result == undefined) {
                        data.rows = [];
                    }
                    return true;
                }
            },
            footerConfig: null
        }, options);

        // ------------------- 自定义参数设置 开始---------------------
        // 是否主动加载数据
        if (options === false || jqGridOptions.firstLoad === false) { // 不主动加载数据
            jqGridOptions.datatype = 'local';
        }
        // 设置Footer，例如：footerConfig: {'saleCompanyName': '已选中 [{R.count}] 条','invAmount': 'sum()', 'invTax': 'sum()', 'invTotalAmount': 'sum()'}
        if(jqGridOptions.footerConfig && typeof (jqGridOptions.footerConfig) === 'object') {
            jqGridOptions.footerrow = true;
            jqGridOptions.refreshFooter = function () {
                // 处理结果
                var R = {
                    /** 总数 */
                    count: 0,
                    /** 选中的ID */
                    selectedIds: jqGridObject.jqGrid("getGridParam", "selarrrow"),
                    /**
                     * 根据模板计算值
                     * @param object 数据
                     * @param name 字段名称
                     * @param express 模板表达式
                     * @returns {*}
                     */
                    _evalValue: function(object, name, express) {
                        var R = this, I = object;
                        if(express === 'sum()'){                     // 固定值：sum()
                            return addCalc(R[name] || 0, object[name] || 0, 2);
                        } else if(typeof (express) === 'function') { // 函数：functionName(字段名，数据，当前结果)
                            return express(name, object, R);
                        } else if(typeof (express) === 'string') {   // 模板字符串：“已选择 {R.count} 行”
                            var pattern = /\{(.*?)\}/gi, result;
                            while ((result = pattern.exec(express)) != null)  {
                                express = express.replace(result[0], eval(result[1]));
                            }
                            return express;
                        } else {
                            return express;
                        }
                    }
                };
                // 计算默认值
                for(var name in jqGridOptions.footerConfig){
                    R[name] = R._evalValue({}, name, jqGridOptions.footerConfig[name]);
                }
                // 计算最终的值
                for(var i = 0; i < R.selectedIds.length; i++){
                    // 统计总数
                    R.count = R.count + 1;
                    // 行数据
                    var item = jqGridObject.jqGrid("getRowData", R.selectedIds[i]);
                    // 计算
                    for(var name in jqGridOptions.footerConfig){
                        R[name] = R._evalValue(item, name, jqGridOptions.footerConfig[name]);
                    }
                }
                // 刷新Footer
                jqGridObject.footerData('set', R);
            };
            jqGridOptions._onPaging = clone(jqGridOptions.onPaging);
            jqGridOptions._onSelectRow = clone(jqGridOptions.onSelectRow);
            jqGridOptions._onSelectAll = clone(jqGridOptions.onSelectAll);
            jqGridOptions._loadBeforeSend = clone(jqGridOptions.loadBeforeSend);
            jqGridOptions.onPaging = function () {
                jqGridOptions._onPaging && jqGridOptions._onPaging();
                jqGridOptions.refreshFooter();
            };
            jqGridOptions.onSelectRow = function () {
                jqGridOptions._onSelectRow && jqGridOptions._onSelectRow();
                jqGridOptions.refreshFooter();
            };
            jqGridOptions.onSelectAll = function () {
                jqGridOptions._onSelectAll && jqGridOptions._onSelectAll();
                jqGridOptions.refreshFooter();
            };
            jqGridOptions.loadBeforeSend = function () {
                jqGridOptions._loadBeforeSend && jqGridOptions._loadBeforeSend();
                jqGridOptions.refreshFooter();
            };
        }
        // ------------------- 自定义参数设置 结束---------------------
        // 初始化表格
        jqGridObject.jqGrid(jqGridOptions);//.navGrid("#" + jqGridId + "Pager", {edit: false, add: false, del: false});

        // 设置基本函数
        var searcher = {
            getRawData: function (id) {
                var rows = rawData.rows ? rawData.rows : rawData;
                if (id) {
                    for (var i = 0; i < rows.length; i++) {
                        if (rows[i]['id'] == id) {
                            return rows[i];
                        }
                    }
                    return null;
                }
                return rows;
            },
            jqGrid: jqGridObject,
            options: jqGridOptions,
            query: function (currentPage) {
                if(searchForm.valid && !searchForm.valid()) {
                    return false;
                }
                var params = {
                    datatype: 'json',
                    postData: searchForm.serializeObject()
                };
                if(!currentPage) params.page = 1;
                jqGridObject.jqGrid('setGridParam', params).trigger("reloadGrid");
            },
            getSelectedRows: function (field) { // 可以只获取指定字段的值
                var rowData = [];
                var rowIds = jqGridObject.jqGrid("getGridParam", "selarrrow");
                for (var i = 0; i < rowIds.length; i++) {
                    var item = jqGridObject.jqGrid("getRowData", rowIds[i]);
                    rowData.push(typeof field === 'string' ? item[field] : item);
                }
                return rowData;
            },
            getSelectedOriginalRows: function (field) {//可以获取指定字段的原始值,例子参考views/masterdata/vendoruser/edit[145-148]
                var rowData = [];
                var rowIds = jqGridObject.jqGrid("getGridParam", "selarrrow");
                for (var i = 0; i < rowIds.length; i++) {
                    var item = this.getRawData(rowIds[i]);
                    rowData.push(typeof field === 'string' ? item[field] : item);
                }
                return rowData;
            },
            callback: function (msg) {
                return function (msg, searcher) {
                    Dialog.msg(msg, searcher.query);
                }
            },
            refreshFooter: function () {
                this.options.refreshFooter && this.options.refreshFooter();
            }
            // 其他常用函数
        };

        // 取消form的默认提交事件
        searchForm[0].onsubmit = function () {
            return false;
        };
        // 绑定查询按钮
        searchButton.click(function () {
            searcher.query();
            return false;
        });
        // 加载尾行
        searcher.refreshFooter();

        // 返回jqGrid句柄
        return searcher;
    },
    createTreeTable: function (table, rowTpl, options) {
        var treeTable = $(table), treeTableId = treeTable.attr('id');
        var treeTableList = $('#' + treeTableId + 'List');
        var searchForm = $('#' + treeTableId + 'Form');
        var searchButton = searchForm.find(':submit');
        var searchUrl = searchForm.attr('action');

        var treeTableOptions = $.extend({
            //请求对象
            postData: {},
            constant: {},
            parentId: 'parentId'
        }, options);

        var operation = {
            url: searchUrl,
            tpl: rowTpl,
            tableList: treeTableList,
            options: treeTableOptions,
            addRow: function (data, pid, root) {
                for (var i = 0; i < data.length; i++) {
                    var row = data[i];
                    this.constantData(row);
                    if ((!row ? '' : !row[options.parentId] ? '' : row[options.parentId]) == pid) {
                        treeTableList.append(Mustache.render(this.getTplContent(), {
                            pid: (root ? 0 : pid), row: row
                        }));
                        this.addRow(data, row.id);
                    }
                }
            },
            constantData: function (data) {
                for (var Key in data) {
                    $(options.constant).each(function (i, obj) {
                        var thisObj = obj[Key];
                        if (thisObj != undefined) {
                            var value = thisObj[data[Key]];
                            data[Key] = thisObj[value == undefined ? '-1' : data[Key]]
                        }
                    });
                }
            },
            query: function (option) {
                option = $.extend({postDate: {}}, option);
                option.constant = options.constant;
                option.parentId = options.parentId;
                $(treeTableId + "List").html("");
                this.refresh(option);
            },
            refresh: function (options) {
                var tpl = operation.getTplContent();
                if (typeof (this.url) == 'string') {
                    Page.ajaxPOST(this.url, options.postData, function (data) {
                        operation.addRow(treeTableId + "List", tpl, data.result, 0, true);
                        // 取消所有事件
                        treeTable.unbind('click mouseover mouseout');
                        treeTable.treeTable({expandLevel: 5});
                    });
                } else {
                    alert('url参数必须是string类型');
                    return false;
                }
            },
            getTplContent: function () {
                return $(this.tpl).html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g, "");
            }
        };

        operation.refresh({postData: searchForm.serialize()});

        // 取消form的默认提交事件
        searchForm[0].onsubmit = function () {
            return false;
        };
        // 绑定查询按钮
        // searchButton.click(function () {
        //     options.query({postData: searchForm.serialize()});
        //     return false;
        // });

        return operation;
    }
};

/**
 * 格式化类
 */
var Formatter = {
    Date: function (value, row, index) {
        return isNaN(value) ? value : $.formatDate("yyyy-MM-dd", new Date(value));
    },
    Currency: function (value, row, index) {
        return formatCurrency(value);
    },
    TaxRate: function (value, row, index) {
        return ((value && value != '' ? value : 0) / 100.0).toFixed(2) + '';
    },
    Price: function (value, row, index) {
        return Number(formatCurrency(value)).toFixed(12);
    },
    Amount: function (value, row, index) {
        return formatCurrency(value);//((value && value != '' ? value : 0) * 1).toFixed(2) + '';
    },
    Number: function (value, row, index) {
        return ((value && value != '' ? value : 0) * 1).toFixed(2) + '';
    },
    Remark: function (value, row, index) {
        return '<textarea id="invRemark' + row.id + '" style="display: none">' + value + '</textarea>'
            + '<a href="javascript:void(0);" onclick="clickRemark($(\'#invRemark' + row.id + '\').val())">查看备注</a>';
    },
    LongText: function (length, alertText, showText) {//例子:vendor/list.jsp[103]
        return function (value, options, row) {
            value = value || '';
            if (value == null || value.length <= length) {
                return value;
            }
            var alertText_ = alertText || value;
            var showText_ = showText || '......';
            alertText_ = typeof(alertText_) == 'function' ? alertText_(value, options, row) : alertText_;
            showText_ = typeof(showText_) == 'function' ? showText_(value, options, row) : showText_;
            var html = $('<label onclick="layer.alert(this.title,{shadeClose:true})">' + value.substring(0, length) + showText_ + '</label>');
            html.attr('title', alertText_);
            return html[0].outerHTML;
        };
    },
    showDesc: function (map, defvalue) { //例子:vendor/list.jsp[96,98]
        defvalue = defvalue || '';
        return function (value, options, row) {
            return map[value] ? map[value] : defvalue;
        }
    },
    aHref:function(hrefUrl,attr){ //表单指定字段增加a标签跳转 例子：资源维护
        attr = (attr == null) ? "id" : attr;
        return function(value, options, row){
            return "<a href='"+hrefUrl+"?"+attr+"="+row[attr]+"'>"+value+"</a>";
        }
    }
};

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};