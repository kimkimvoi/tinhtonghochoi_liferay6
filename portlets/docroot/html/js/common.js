//functions which validate input on client side --START--

function isNumber(n) {
	return !isNaN(parseFloat(n)) && isFinite(n);
}

// functions which validate input on client side --END--

// functions which provide pagination --START--
function getPage(tableId, spanItem, pageNumInputId, curPageId) {
	var pageNum = $(spanItem).find('#' + pageNumInputId).val();
	if (pageNum == $("#" + curPageId).val()) {
		return;
	}
	callAjaxLoadPage(tableId, pageNum, curPageId);
}

function getPreviousPage(tableId, curPageId) {
	var pageNum = $("#" + curPageId).val() - 1;
	if (pageNum < 1) {
		return;
	}
	callAjaxLoadPage(tableId, pageNum, curPageId);
}

function getNextPage(tableId, curPageId, numOfPage) {
	var pageNum = $("#" + curPageId).val() - (-1);
	if (pageNum > numOfPage) {
		return;
	}
	callAjaxLoadPage(tableId, pageNum, curPageId);
}

function getFirstPage(tableId, curPageId) {
	callAjaxLoadPage(tableId, 1, curPageId);
}

function getLastPage(tableId, curPageId, numOfPage) {
	callAjaxLoadPage(tableId, numOfPage, curPageId);
}

function updateItemsPerPageNum(input, tableId, curPageId) {
	var numPerPage = $(input).val();
	var itemsPerPageCurValId = tableId + "_itemsPerPageCurValId";
	if (!isNumber(numPerPage) || numPerPage <= 0) {
		var curNumPerPage = $("#" + itemsPerPageCurValId).val();
		$(input).val(curNumPerPage);
		return;
	}
	$("#" + itemsPerPageCurValId).val(numPerPage);
	getFirstPage(tableId, curPageId);
}

function callAjaxLoadPage(tableId, pageNum, curPageId) {
	var loadPageURLId = tableId + "_loadPageURL";
	var numPerPage = $("#" + tableId + "_itemsPerPageInput").val();
	if (!isNumber(numPerPage) || numPerPage <= 0) {
		return;
	}
	$.ajax({
		sync : false,
		url : $("#" + loadPageURLId).val(),
		data : {
			'pageNum' : pageNum,
			'numPerPage' : numPerPage
		},
		dataType : 'json',
		type : "POST",
		success : function(data) {
			renderTable(tableId, data, pageNum, curPageId);
		},
		error : function(response) {
			alert("error");
		}
	});
}

function toggleIndicator(row) {
	var expanding = $(row).find(".expandRowIndicator").css("display") == "none";
	$("tr.dataRow").find(".expandRowIndicator").css("display", "inline");
	$("tr.dataRow").find(".collapseRowIndicator").css("display", "none");

	if (expanding) {
		$(row).find(".expandRowIndicator").css("display", "inline");
		$(row).find(".collapseRowIndicator").css("display", "none");
	} else {
		$(row).find(".expandRowIndicator").css("display", "none");
		$(row).find(".collapseRowIndicator").css("display", "inline");
	}
}

function addIndicator(col, tdContent) {
	var indicatorList = $("#indicatorList").val();
	if (indicatorList.indexOf(col) < 0) {
		return tdContent;
	}

	var contextPath = $("#contextPath").val();
	var indicatorImage = "<img class='expandRowIndicator' src='" + contextPath
			+ "/html/images/arrows/bullet-arrow-down-icon.png' alt='+' />"
			+ "<img class='collapseRowIndicator' style='display:none;' src='"
			+ contextPath
			+ "/html/images/arrows/bullet-arrow-up-icon.png' alt='+' />";
	var result = "<table style='border:none' ><tr>";
	result += "<td style='border:none; padding:0px;' >" + tdContent + "</td>";
	result += "<td style='border:none; padding:0px;' width='16px' height='16px' align='right' >"
			+ indicatorImage + "</td>";
	result += "</tr></table>";
	return result;
}

function renderTable(tableId, data, pageNum, curPageId) {
	var items = $.parseJSON(data.items);
	var recordPerPage = $.parseJSON(data.recordPerPage);
	var numOfPage = data.numOfPage;
	var headers = convertToArray(tableId + "_headerList");
	var displayedPropertyList = convertToArray(tableId
			+ "_displayedPropertyList");
	var hiddenPropertyList = convertToArray(tableId + "_hiddenPropertyList");
	var curPageTextId = tableId + "_curPageText";
	var headerClass = $("#" + tableId + "_headerClass").val();
	var tableContent = "<tr class='" + headerClass + "'>";
	var isClickRow = data.isClickRow;
	var indicatorList = $("#indicatorList").val();
	var showIndicator = (indicatorList != null)
			&& (indicatorList.split(",").length > 0);
	var thNum = 1;
	var headerId = "";
	for (var i = 0; i < headers.length; i++) {
		headerId = tableId + "_th" + thNum;
		tableContent += "<th id='" + headerId + "'>" + headers[i] + "</th>";
		thNum++;
	}
	tableContent += "</tr>";
	for (var i = 0; i < items.length; i++) {
		if (isClickRow) {
			tableContent += "<tr class='dataRow' onclick = '" + tableId
					+ "_onClick(this);'>";
		} else if (showIndicator) {
			tableContent += "<tr class='dataRow' onclick='toggleIndicator(this)' >";
		} else {
			tableContent += "<tr class='dataRow'>";
		}

		for (var j = 0; j < displayedPropertyList.length; j++) {
			var displayedProperty = $.trim(displayedPropertyList[j]);
			if (displayedProperty == "_stt") {
				var stt = i + 1 + recordPerPage * (pageNum - 1);

				if (showIndicator) {
					tableContent += "<td>" + addIndicator(j, stt) + "</td>";
				} else {
					tableContent += "<td>" + stt + "</td>";
				}
			} else {
				var displayedPropertySubArray = displayedProperty.split("&");
				var displayedValue = "";
				if (items[i][displayedPropertySubArray[0]] != undefined) {
					displayedValue = items[i][displayedPropertySubArray[0]];
				}
				if (displayedPropertySubArray.length > 1) {
					for (var a = 1; a < displayedPropertySubArray.length; a++) {
						if (items[i][displayedPropertySubArray[a]] != undefined) {
							displayedValue = displayedValue + " "
									+ items[i][displayedPropertySubArray[a]];
						}
					}
				}

				if (showIndicator) {
					tableContent += "<td>" + addIndicator(j, displayedValue)
							+ "</td>";
				} else {
					tableContent += "<td>" + displayedValue + "</td>";
				}
			}
		}

		if (null != hiddenPropertyList && hiddenPropertyList.length > 0) {
			tableContent += "<td style='display:none;'>";
			for (var j = 0; j < hiddenPropertyList.length; j++) {
				/* var hiddenProperty = hiddenPropertyList[j].trim(); */
				var hiddenProperty = $.trim(hiddenPropertyList[j]);
				tableContent += "<input type='hidden' class='" + hiddenProperty
						+ "' value='" + items[i][hiddenProperty] + "'/>";
			}
			tableContent += "</td>";
		}

		tableContent += "</tr>";
	}
	$("#" + tableId).html(tableContent);

	$("#" + curPageId).val(pageNum);
	$("span#" + curPageTextId).html(pageNum, curPageId);
	renderPaginator(tableId, numOfPage, curPageId, pageNum);
}

function renderPaginator(tableId, numOfPage, curPageId, pageNum) {

	// build current total page status
	var totalPageStatusId = tableId + "_totalPageStatus";
	$("#" + totalPageStatusId).html(numOfPage);
	// build first page icon
	var firstPageButtonId = tableId + "_firstPageButton";
	var pagingDivId = tableId + "_pagingDiv";
	var tableMsgId = tableId + "_tableMsgId";

	if (numOfPage <= 0) {
		var msg = Liferay.Language.get("common.msg.noSearchResult");
		$("#" + tableMsgId).html(msg);
		$("#" + pagingDivId).hide();
	} else {
		$("#" + tableMsgId).html("");
		$("#" + pagingDivId).show();
	}

	if (numOfPage <= 1) {
		$("#" + firstPageButtonId).html("");
	} else if (numOfPage > 1) {
		var firstPageButton = "";
		if (pageNum == 1) {
			firstPageButton = "<span id=\"firstPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px; color: #CACACA; cursor: default;'>|<</span>";
		} else {
			firstPageButton = "<span id=\"firstPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px;' onClick=\"getFirstPage('"
				+ tableId + "', '" + curPageId + "')\">|<</span>";
		}
		
		$("#" + firstPageButtonId).html(firstPageButton);
	}

	// build previous page icon
	var prevPageButtonId = tableId + "_prevPageButton";
	if (numOfPage <= 1) {
		$("#" + prevPageButtonId).html("");
	} else if (numOfPage > 1) {
		var prevPageButton = "";
		if (pageNum == 1) {
			prevPageButton = "<span id=\"previousPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px; color: #CACACA; cursor: default;'>|<</span>";
		} else {
			prevPageButton = "<span id=\"previousPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px;' onClick=\"getPreviousPage('"
				+ tableId + "', '" + curPageId + "')\"><</span>";
		}
		$("#" + prevPageButtonId).html(prevPageButton);
	}

	// build page number
	var pageNumSpan = "";
	var pageNumId = tableId + "_pageNum";
	var pageNumSpanId = tableId + "_pageNums";
	var curPageNum = $("#" + curPageId).val();

	if (numOfPage > 0) {
		var startPage = curPageNum - 1;
		var pageRangeId = tableId + "_pageRangeId";
		var pageRange = $("#" + pageRangeId).val() * 1;

		if (startPage < 1) {
			startPage = 1;
		}

		var endPage = (startPage + pageRange) - 1;
		if (endPage > numOfPage) {
			endPage = numOfPage;
			startPage = endPage - pageRange + 1;
			if (startPage < 1) {
				startPage = 1;
			}
		}

		for (var i = startPage; i <= endPage; i++) {
			if (i == curPageNum) {
				pageNumSpan += "<span id='"
						+ pageNumId
						+ i
						+ "' class='pagingNumber activePage' style='cursor: pointer' onClick=\"getPage('"
						+ tableId + "', this, 'page" + i + "', '" + curPageId
						+ "')\" >" + i + "<input type=\'hidden\' id=\'page" + i
						+ "\' value=\'" + i + "\'/>" + "</span>";
			} else {
				pageNumSpan += "<span id='"
						+ pageNumId
						+ i
						+ "' class='pagingNumber' style='cursor: pointer' onClick=\"getPage('"
						+ tableId + "', this, 'page" + i + "', '" + curPageId
						+ "')\" >" + i + "<input type=\'hidden\' id=\'page" + i
						+ "\' value=\'" + i + "\'/>" + "</span>";
			}
		}

		$("#" + pageNumSpanId).html(pageNumSpan);

		// build next page icon
		var nextPageButtonId = tableId + "_nextPageButton";
		if (numOfPage <= 1) {
			$("#" + nextPageButtonId).html("");
		} else if (numOfPage > 1) {
			var nextPageButton = '';
			if (pageNum == numOfPage) {
				nextPageButton = "<span id=\"nextPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px; color: #CACACA; cursor: default;'>></span>";
			} else {
				nextPageButton = "<span id=\"nextPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px;' onClick=\"getNextPage('"
					+ tableId
					+ "', '"
					+ curPageId
					+ "', '"
					+ numOfPage
					+ "')\">></span>";
			}
			
			$("#" + nextPageButtonId).html(nextPageButton);
		}

		// build last page icon
		var lastPageButtonId = tableId + "_lastPageButton";
		if (numOfPage <= 1) {
			$("#" + lastPageButtonId).html("");
		} else if (numOfPage > 1) {
			var lastPageButton = '';
			if (pageNum == numOfPage) {
				    lastPageButton = "<span id=\"lastPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px; color: #CACACA; cursor: default;'>>|</span>";
			} else {
				    lastPageButton = "<span id=\"lastPageElementButton\" class='pagingNumber padding' style='cursor: pointer;margin-right: 2px;' onClick=\"getLastPage('"
					+ tableId
					+ "', '"
					+ curPageId
					+ "', '"
					+ numOfPage
					+ "')\">>|</span>";
			}
			
			$("#" + lastPageButtonId).html(lastPageButton);
		}

		/*if (startPage > 1) {
			$("#" + tableId + "_firstPageButton").find("span").css("color",
					"#000000");
		} else {
			$("#" + tableId + "_firstPageButton").find("span").css("color",
					"#CCCCCC");
		}

		if (numOfPage > pageRange && endPage != numOfPage) {
			$("#" + tableId + "_lastPageButton").find("span").css("color",
					"#000000");
		} else {
			$("#" + tableId + "_lastPageButton").find("span").css("color",
					"#CCCCCC");
		}*/
	}
}

function convertToArray(inputId) {
	var inputStr = $("#" + inputId).val();
	if (null != inputStr && undefined != inputStr && "" != inputStr) {
		inputStr = inputStr.substring(1, inputStr.length - 1);
		return inputStr.split(",");
	}
	return null;
}

// new paging implementation

function showLoadingIndicator(wrapperCSSSelector, loadingClass) {
	var div = $(wrapperCSSSelector);
	div.css("opacity", 50);
	div.prepend('<div class="pagingLoadingIndicator ' + loadingClass
			+ '"></div>');
}
function hideLoadingIndicator(wrapperCSSSelector, loadingClass) {
	var div = $(wrapperCSSSelector);
	div.css("opacity", 100);
	div.children('.pagingLoadingIndicator.' + loadingClass + '').remove();
}

/**
 * call ajax to get new page and rebuild new page HTML and paging HTML markup
 * 
 * @author ThangBN1
 */
function getPage_new(oldData, pageNum) {
	//KienNN
	//when implement search and current page is 1
//	if (pageNum == oldData.currentPageNum) {
//		return;
//	}
	
	if (pageNum == oldData.currentPageNum && oldData.searchKey == undefined) {
		return;
	}

	showLoadingIndicator(oldData.pageWrapperCSSSelector, oldData.loadingClass);

	var loadPageURL = oldData.loadPageURL;
	var keyword = '';
	if (oldData.searchKey != undefined) {
		keyword = $(oldData.searchKey).val();
	}
	if (oldData.searchButton != undefined) {
		$(oldData.searchButton).attr('onclick','getPage_new('+oldData.id+', 1)');
	}

	$
			.ajax({
				sync : false,
				url : loadPageURL,
				data : {
					'pageNum' : pageNum,
					'recordPerPage' : oldData.recordPerPage,
					'keyword' : keyword
				},
				dataType : 'json',
				success : function(newPageData) {
					if (loadPageURL == null && newPageData.loadPageURL == null) {
						console
								.log("can not find load page URL in the response and old data object");
						return;
					}
					_.extend(oldData, newPageData);
					if (newPageData.loadPageURL == undefined
							|| newPageData.loadPageURL == null) {
						oldData.loadPageURL = loadPageURL;
					}
					renderPageAndPaginator_new(oldData);
					hideLoadingIndicator(oldData.pageWrapperCSSSelector,
							oldData.loadingClass);
				},
				error : function(response) {
					console.log("error");
					console.log(response);
					hideLoadingIndicator(oldData.pageWrapperCSSSelector,
							oldData.loadingClass);
				}
			});
}

/**
 * TODO: check it, not tested yet
 * 
 * @author ThangBN1
 */
function updateItemsPerPageNum_new(data, input) {
	var recordPerPage = $(input).val();
	if (!isNumber(recordPerPage)) {
		$(input).val(data.recordPerPage);
		return;
	}
	data.recordPerPage = recordPerPage;
	$("#" + data + "_itemsPerPageCurValId").val(recordPerPage);
	getPage_new(data, 1);
}

/**
 * @author ThangBN1
 */
function renderPageAndPaginator_new(data, divId) {
	// if not contain data , load first page
	if (data.items == undefined) {
		getPage_new(data, 1);
		return;
	}

	renderPaginator_new(data, divId);
	waitUntilAvailable(data.renderPageJsFunction, function() {
		$(data.pageWrapperCSSSelector).empty();
		window[data.renderPageJsFunction](data, data.pageWrapperCSSSelector);
	});
}

function waitUntilAvailable(functionName, callback) {
	var retryTime = 0;
	var intervalLoadPage = setInterval(function() {
		if (retryTime == 10) {
			clearInterval(intervalLoadPage);
		}
		if (window[functionName] !== undefined) {
			clearInterval(intervalLoadPage);
			callback();
		}
	}, 500);
}
/**
 * render paginator markup
 * 
 * @author ThangBN1
 */
function renderPaginator_new(data, divId) {

	if (divId === undefined) {
		divId = data.id;
	} else {
		data.id = divId;
	}

	window[data.id] = data;

	if (data.items.length > 0) {
		data.pages = [];
		for (var i = 0; i < data.totalPageNum; i++) {
			data.pages.push({
				index : i + 1
			});
			if ((i + 1) == data.currentPageNum) {
				data.pages[i].active = true;
			}
		}

		loadTemplate("paging", function(template) {
			var newPageHTML = Mustache.render(template, data);
			$('#' + divId).html(newPageHTML);
		});
	}
}
var MAIN_TEMPLATE_FILE = "/tinhdo-portlet/html/js_template/template.html";
var TEMPLATES_FILE = {
	paging : {
		location : MAIN_TEMPLATE_FILE,
		id : "paging"
	},
	news_display_type_title_only : {
		location : MAIN_TEMPLATE_FILE,
		id : "news_display_type_title_only"
	},
	news_display_type_summary : {
		location : MAIN_TEMPLATE_FILE,
		id : "news_display_type_summary"
	}
	,
	news_display_type_table : {
		location : MAIN_TEMPLATE_FILE,
		id : "news_display_type_table"
	}
	,
	news_display_type_visitor : {
		location : MAIN_TEMPLATE_FILE,
		id : "news_display_type_visitor"
	}
};

/**
 * Load template from name config in TEMPLATES_FILE
 * 
 * @author ThangBN1
 * @param templateName
 * @param callback :
 *            callback function to handle received template
 */
function loadTemplate(templateName, callback) {
	var currentTemplate = TEMPLATES_FILE[templateName];
	if (currentTemplate.HTMLcontent == undefined) {
		$.get(currentTemplate.location, function(content) {
			if (currentTemplate.id != undefined) {
				var find = $(content).filter("#" + currentTemplate.id);
				content = find.html();
			}
			currentTemplate.HTMLcontent = content;
			callback(content);
		});
	} else {
		callback(currentTemplate.HTMLcontent);
	}
}
/**
 * @author ThangBN1
 */
function randonLetterString(length) {
	return randomString(length,
			"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
}

/**
 * @author ThangBN1
 */
function randomAlphabetString(length) {
	return randomString(length,
			"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");
}
/**
 * @author ThangBN1
 */
function randomString(length, possible) {
	if (length === undefined) {
		length = 5;
	}
	var text = "";

	for (var i = 0; i < length; i++)
		text += possible.charAt(Math.floor(Math.random() * possible.length));

	return text;
}

var DISPLAY_TYPE_TEMPLATE_NAME = {
	"portlet.news.config.display-type.title-only" : "news_display_type_title_only",
	"portlet.news.config.display-type.summary" : "news_display_type_summary",
	"portlet.news.config.display-type.visitor" : "news_display_type_visitor"
// "portlet.news.config.display-type.table" : "news_display_type_table"
};

/**
 * @author ThangBN1
 */
function renderListByCategoryPage(data, cssSelector) {
	if (typeof data.displayType == 'undefined' || data.displayType == "") {
		return;
	}
	
	data.first = data.items[0];
	
	loadTemplate(DISPLAY_TYPE_TEMPLATE_NAME[data.displayType], function(
			htmlTemplate) {
		$(cssSelector).html(Mustache.render(htmlTemplate, data));
	});
	// }
}

function renderListByCategoryPageTable(data, cssSelector) {
	// transform data to display in table
	var fields = data.detailTableFields;
	var portalURL = data.portalURL;
	console.log(fields);
	console.log(data);
	_.each(data.items, function(item, i, list) {
		item.ordinal = i + 1;
		var otherProps = item.otherProps;
		var newOtherProps = [];
		var attachFiles = [];
		var links = [];

		// if prop count equal to detail table rows field, simply loop and push
		// to the array
		if (_.keys(otherProps).length == fields.length) {
			for (prop in otherProps) {
				if (prop == "Văn bản đính kèm"
						&& otherProps[prop] != "") {
					var urls = otherProps[prop].split(',');
					var i = urls.length;
					for(var j=0; j<i; j++){
						links.push({link : portalURL +urls[j]});
					}
					attachFiles.push({
						key : prop,
//						value : portalURL + otherProps[prop]
						value : links
					});
					continue;
				} 
				newOtherProps.push({
					key : prop,
					value : otherProps[prop]
				});
			}
		} else {
			// if not, loop and check push to the array
			_.each(fields, function(field, index, list1) {
				if (otherProps[field] != undefined) {
					newOtherProps.push({
						key : field,
						value : otherProps[field]
					});
				} else {
					newOtherProps.push({
						key : field,
						value : ""
					});
				}
			});
		}
		item.newOtherProps = newOtherProps;
		item.attachFiles = attachFiles;
		console.log(newOtherProps);
		console.log(attachFiles);
	});

	loadTemplate("news_display_type_table", function(htmlTemplate) {
		$(cssSelector).html(Mustache.render(htmlTemplate, data));
	});
	// }
}
/**
 * @author ThangBN1
 */
function loadCategoryPageTab(categoryId, tabContentId, URL, includePaging) {

	$.ajax({
		url : URL,
		data : {
			categoryId : categoryId
		},
		datatype : 'json',
		success : function(data) {
			
			var string = "#" + tabContentId + " .list_new";
			if (includePaging == true) {
				data.renderPageJsFunction = "renderListByCategoryPage";
				data.pageWrapperCSSSelector = string;
				var pagingWrpDiv = $('#' + tabContentId + ' div.paging');
				pagingWrpDiv.attr('id', randonLetterString(10));
				renderPageAndPaginator_new(data, pagingWrpDiv.attr('id'));
			} else {
				renderListByCategoryPage(data, string);
			}
			console.log(data);
			$('#' + tabContentId + ' .link_more').attr('href',data.loadPageURL);
//			$('#_newsbycategoriestab_WAR_tinhdoportlet_INSTANCE_x5BWbw3FAAab_2 .link_more').attr('href','dsdf')
		},
		error : function(e) {
			console.log(e);
		}
	});
}

function renderTableClicker(fields, jsonData) {
	if (fields != undefined && fields.length > 0) {
		var html = '<table border="1"><tr>';
		for (var int = 0; int < fields.length; int++) {
			html += '<td>' + fields[int] + '</td>';
			html += '<td>' + jsonData[fields[int]] + '</td>';
		}
		return html += '</tr></table>';
	}
}

// function create tooltip for help -------
function createTooltipHelp(idOfElement, contentOfTooltip) {
	AUI().ready('aui-tooltip', 'aui-io-plugin', function(A) {
		new A.Tooltip({
			trigger : '#' + idOfElement,
			bodyContent : Liferay.Language.get(contentOfTooltip),
		}).render();
	});
}

function clickViewcount() {
	var topViewFixTime = $('#topViewFixTime');
	topViewFixTime.removeAttr("hidden");
}

function clickLatest() {
	var topViewFixTime = $('#topViewFixTime');
	topViewFixTime.attr('hidden', 'true');
}

function clickViewHotNews() {
	var topViewFixTime = $('#topViewFixTime');
	topViewFixTime.attr('hidden', 'true');
}

function setFileNameToHiddenField(tag, value) {
	$(tag).prev().val(value);
}
function addFileTag(tag, tagName, hiddenTagName, mimeType) {
	$(tag)
			.before(
					'<div style="padding-top:5px;"><input type="hidden" name="'
							+ hiddenTagName
							+ '"/><input type="file" onchange="setFileNameToHiddenField(this,this.value)"'
							+ 'onblur="isValidFile(this, this.value ,\''
							+ mimeType
							+ '\')"'
							+ ' name="'
							+ tagName
							+ '"><img style="cursor: pointer;" onclick="removeFileTag(this)" src="'
							+ $('#CONTEXT_PATH').val()
							+ '/html/images/button/delete.png" ></div>');
}
function removeFileTag(tag) {
	tag.parentElement.remove();
}
function isValidFile(element, fileName, acceptType) {
	if (fileName.length > 0) {
		var fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase();
		var arrayAcceptType = acceptType.toUpperCase().split(',');
		for (var i = 0; i < arrayAcceptType.length; i++) {
			if (arrayAcceptType[i] == fileExt) {
				return true;
			}
		}
		$(element).val('');
		$(element).prev().val('');
		alert('Tài liệu đính kèm chỉ hỗ trợ định dạng sau (' + acceptType + ')');
		return false;
	}
}
// END MUTIL UIPLOADER
