// 參數
let parametersArray = [];
let parameter = "?";
let publisher_tw = "publisher_tw=";
let publisher_jp = "publisher_jp=";
let search = "search=";
let order = "order=";
let sort = "sort=";

// 出版社
const publisherList_tw = [
    "台灣角川", 
    "青文", 
    "尖端", 
    "東立", 
    "長鴻", 
    "台灣東販"
]

// 排序項目
const sortItem = [
    "published_date_tw", 
    "published_date_jp"
]

// 排序方式
const sortMethod = [
    "DESC", // 降序
    "ASC"   // 升序
]

// 目前請求書籍網址
let bookUrl = "http://localhost:8080/books";

// 取得書籍
function getBook(bookUrl){
    fetch(bookUrl)
    .then(response => {
        return response.json();
    })
    .then(data => {
        const books = data.result;
        const container = document.getElementById("contents");
        container.innerHTML = '';
        books.forEach(book => {
            const bookCard = document.createElement("div");
            bookCard.className = "book-card";
            bookCard.innerHTML = `
                <div class="book-image-container">
                    <img src="${book.cover_url}" class="book-image">
                </div>
                <div class="book-info">
                    <h3 class="title-tw">${book.title_tw}</h3>
                    <p lang="jp-jp" class="title-jp font-jp">${book.title_jp}</p>
                    <p lang="jp-jp" class="author font-jp">${book.author}</p>
                    <div class="publishing-info-container">
                        <div class="publishing-info">
                            <p lang="jp-jp" class="publisher font-jp">${book.publisher_jp}</p>
                            <p class="published-date">${book.published_date_jp}</p>
                        </div>
                        <div class="publishing-info">
                            <p class="publisher">${book.publisher_tw}</p>
                            <p class="published-date">${book.published_date_tw}</p>
                        </div>
                    </div>
                </div>
                `;
            bookCard.addEventListener("click", function () {
                params.set("search", book.title_tw);
                const finalUrl = `http://localhost:8080/books?${params.toString()}`;
                getBookDetail(finalUrl);
                params.delete("search");
            });
            container.appendChild(bookCard);
        });
    })
    .catch(error => {
        console.error(error);
    });
}

// 取得書籍資訊
function getBookDetail(bookUrl){
    fetch(bookUrl)
    .then(response => {
        return response.json();
    })
    .then(data => {
        const books = data.result;
        const container = document.getElementById("book-detail-container");
        container.style.display = "block";
        container.innerHTML = '';
        books.forEach(book => {
            const bookCard = document.createElement("div");
            bookCard.className = "book-detail";
            bookCard.innerHTML = `
                <h1 class="title">書籍資訊</h1>
                <h2 class="sub-title">Book Info</h2>
                <div class="book-image-container">
                    <img class="book-image" src="${book.cover_url}" alt="">
                </div>
                <div class="title-container">
                    <p class="lable">書名</p>
                    <h3 class="book-title">${book.title_tw}</h3>
                    <p class="lable">原文書名</p>
                    <p lang="jp-jp" class="book-title font-jp">${book.title_jp}</p>
                    <p class="lable">作者</p>
                    <p lang="jp-jp" class="author">${book.author}</p>
                </div>
                <div class="details">
                    <div class="detail-jp">
                        <div class="detail-container">
                            <p class="lable">原文出版社</p>
                            <p lang="jp-jp" class="publisher font-jp">${book.publisher_jp}</p>
                        </div>
                        <div class="detail-container">
                            <p class="lable">原文出版日期</p>
                            <p class="published-date">${book.published_date_jp}</p>
                        </div>
                        <div class="detail-container">
                            <p class="lable">原文ISBN</p>
                            <p class="published-date">${book.isbn_jp}</p>
                        </div>
                    </div>
                    <div class="detail-tw">
                        <div class="detail-container">
                            <p class="lable">臺灣出版社</p>
                            <p class="publisher">${book.publisher_tw}</p>
                        </div>
                        <div class="detail-container">
                            <p class="lable">臺灣出版日期</p>
                            <p class="published-date">${book.published_date_tw}</p>
                        </div>
                        <div class="detail-container">
                            <p class="lable">臺灣ISBN</p>
                            <p class="published-date">${book.isbn_tw}</p>
                        </div>
                    </div>
                </div>
                `;
            container.appendChild(bookCard);
        });
    })
    .catch(error => {
        console.error(error);
    });
}

// 開啟首頁後請求所有書籍資料
window.onload = function() {
    getBook(bookUrl);
};

// 設定按鈕樣式
const allItems = document.querySelectorAll(".item-filter");
allItems.forEach((item) => {
    item.addEventListener("click", function () {
        allItems.forEach((item) => {
            item.className = "item item-default item-filter";
        })
        this.className = "item item-selected item-filter";
    });
});

// 篩選
let params = new URLSearchParams();
let currentPublisher = "";

// 選單
    // 所有書籍
    document.getElementById("allBook").addEventListener("click", function () {
        params.delete("publisher_tw");
        const finalUrl = `http://localhost:8080/books?${params.toString()}`;
        getBook(finalUrl);
    });

    // 台灣角川
    document.getElementById("kadokawaTaiwan").addEventListener("click", function () {
        params.set("publisher_tw", publisherList_tw[0]);
        currentPublisher = publisherList_tw[0];
        const finalUrl = `http://localhost:8080/books?${params.toString()}`;
        getBook(finalUrl);
    });

    // 青文
    document.getElementById("chingWin").addEventListener("click", function () {
        params.set("publisher_tw", publisherList_tw[1]);
        currentPublisher = publisherList_tw[1];
        const finalUrl = `http://localhost:8080/books?${params.toString()}`;
        getBook(finalUrl);
    });

    // 尖端
    document.getElementById("sharpPoint").addEventListener("click", function () {
        params.set("publisher_tw", publisherList_tw[2]);
        currentPublisher = publisherList_tw[2];
        const finalUrl = `http://localhost:8080/books?${params.toString()}`;
        getBook(finalUrl);
    });

    // 東立
    document.getElementById("tongLi").addEventListener("click", function () {
        params.set("publisher_tw", publisherList_tw[3]);
        currentPublisher = publisherList_tw[3];
        const finalUrl = `http://localhost:8080/books?${params.toString()}`;
        getBook(finalUrl);
    });

    // 長鴻
    document.getElementById("everGlory").addEventListener("click", function () {
        params.set("publisher_tw", publisherList_tw[4]);
        currentPublisher = publisherList_tw[4];
        const finalUrl = `http://localhost:8080/books?${params.toString()}`;
        getBook(finalUrl);
    });

    // 台灣東販
    document.getElementById("toHan").addEventListener("click", function () {
        params.set("publisher_tw", publisherList_tw[5]);
        currentPublisher = publisherList_tw[5];
        const finalUrl = `http://localhost:8080/books?${params.toString()}`;
        getBook(finalUrl);
    });



// 搜尋書籍
function searchBook() {
    params.set("search", document.getElementById("searchInput").value);
    const finalUrl = `http://localhost:8080/books?${params.toString()}`;
    getBook(finalUrl);
}

// 排序
    // 排序項目
        // 依臺灣出版日期排序
        document.getElementById("sortByPublishedDate_tw").addEventListener("click", function () {
            params.set("order", sortItem[0]);
            const finalUrl = `http://localhost:8080/books?${params.toString()}`;
            document.getElementById("defaultSortItem").innerHTML = `
                <div class="sort-name">
                    臺灣出版日期
                </div>
                <div class="tool-icon">
                    <img src="/src/imgs/mixer-horizontal.svg" alt="">
                </div>
            `;
            getBook(finalUrl);
        });

        // 依日本出版日期排序
        document.getElementById("sortByPublishedDate_jp").addEventListener("click", function () {
            params.set("order", sortItem[1]);
            const finalUrl = `http://localhost:8080/books?${params.toString()}`;
            document.getElementById("defaultSortItem").innerHTML = `
                <div class="sort-name">
                    日本出版日期
                </div>
                <div class="tool-icon">
                    <img src="/src/imgs/mixer-horizontal.svg" alt="">
                </div>          
            `;
            getBook(finalUrl);
        });

    // 排序方式
        // 降序
        document.getElementById("sortByDesc").addEventListener("click", function () {
            params.set("sort", sortMethod[0]);
            const finalUrl = `http://localhost:8080/books?${params.toString()}`;1
            document.getElementById("defaultSortMethod").innerHTML = `
                <div class="sort-name">
                    降序
                </div>
                <div class="tool-icon">
                    <img src="/src/imgs/caret-down.svg" alt="">
                </div>
            `;
            getBook(finalUrl);
        });

        // 升序
        document.getElementById("sortByAsc").addEventListener("click", function () {
            params.set("sort", sortMethod[1]);
            const finalUrl = `http://localhost:8080/books?${params.toString()}`;
            document.getElementById("defaultSortMethod").innerHTML = `
                <div class="sort-name">
                    升序
                </div>
                <div class="tool-icon">
                    <img src="/src/imgs/caret-down.svg" alt="">
                </div>
            `;
            getBook(finalUrl);
        });