function seeMore(category) {
	$('#categorySelect').val(category);
	bookRenderResult();
}
	
bookRenderSelect();
bookRenderResult();

$('#authorSelect').change(function() {
	bookRenderResult();	
});

$('#categorySelect').change(function() {
	bookRenderResult();
});

function bookRenderSelect() {
	var out = "";
	
	out += "<div class='bookSelectDiv'>";
	out += Liferay.Language.get('portlet.booklibrary.search.by.author') + ": <select id='authorSelect' name='author'>";
	out += "<option value='All'></option>";
	$.each(bookAuthorList , function() {
		out += "<option value='" + this + "'>" + this + "</option>";
	});
	out += "</select>";
	
	out += " &nbsp;" + Liferay.Language.get('portlet.booklibrary.search.by.category') + ": <select id='categorySelect' name='category'>";
	out += "<option value='All'></option>";
	$.each(bookCategoryList , function() {
		out += "<option value='" + this + "'>" + this + "</option>";
	});
	out += "</select>";
	out += "</div>";
	$("#selectDiv").html(out);
}

function bookRenderTitle(category, haveSpan) {
	var out = "";
	out += "<h3 class='title_group'>";
	out += category.toUpperCase();
	if (haveSpan) {
		out += "<span style='float: right; padding-right: 10px'>";
		out += "<a href=\"#\" onclick=\"seeMore('" + category +  "')\">" + Liferay.Language.get("portlet.booklibrary.seemore") + "</a>";
		out += "</span>";
	}
	out += "</h3>";
	return out;
}

function renderBook(book) {
	var out = "";
	out += "<div class='book'>";
	out += "<a href='" + book.bookUrl + "' title='" + book.title + "'>";
	out += "<div class='picture' align='center'>";
	out += "<img title='" + book.title + "' src='" + book.coverUrl + "' />";
	out += "</div>";
	out += "<p style='font-size:13px'>" + book.title + "</p>";
	out += "</a>";
	out += "</div>";
	return out;
}

function bookRenderResult() {
	var bookSelectedCategory = $('#categorySelect').val();
	var bookSelectedAuthor = $('#authorSelect').val();
	$("#resultDiv").html('');
	
	var out = "";
	if (bookSelectedAuthor == 'All' && bookSelectedCategory == 'All') {
		$.each(bookCategoryList , function() {
			out += bookRenderTitle(this, true);
			
			out += "<div class='container'>";
			var category = this;
			$.each(bookList, function() {
				var count = 0;
				if (this.category == category && count < 8) {
					count++;
					out += renderBook(this);
				}
			});
			out += "</div>";
		});
	} else if (bookSelectedAuthor != 'All' && bookSelectedCategory == 'All') {
		out += bookRenderTitle("Sách của tác giả " + bookSelectedAuthor, false);
		
		out += "<div class='container'>";
		$.each(bookList, function() {
			if (this.author == bookSelectedAuthor) {
				out += renderBook(this);	
			}
		});
		out += "</div>";
	} else if (bookSelectedAuthor == 'All' && bookSelectedCategory != 'All') {
		out += bookRenderTitle(bookSelectedCategory, false);
		
		out += "<div class='container'>";
		$.each(bookList, function() {
			var count = 0;
			if (this.category == bookSelectedCategory) {
				count++;
				out += renderBook(this);	
			}
		});
		out += "</div>";
	} else {
		out += bookRenderTitle(bookSelectedCategory + " của tác giả " + bookSelectedAuthor, false);
		
		out += "<div class='container'>";
		$.each(bookList, function() {
			var count = 0;
			if (this.author == bookSelectedAuthor && this.category == bookSelectedCategory) {
				count++;
				out += renderBook(this);	
			}
		});
		out += "</div>";
	}
	
	$("#resultDiv").html(out);
}
