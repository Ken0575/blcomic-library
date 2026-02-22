
// 選單按鈕
let allBook = document.getElementById("allBook");
let kadokawaTaiwan = document.getElementById("kadokawaTaiwan");
let chingWin = document.getElementById("chingWin");
let sharpPoint = document.getElementById("sharpPoint");
let tongLi = document.getElementById("tongLi");

let items = document.getElementsByClassName("items");

const allItems = document.querySelectorAll(".item-filter");
allItems.forEach((item) => {
    item.addEventListener("click", function () {
        allItems.forEach((item) => {
            item.className = "item-default";
        })
        this.className = "item-selected";
    });
});


allBook.addEventListener("click", function () {
    const bookUrl = "http://localhost:8080/books";
    getBook(bookUrl);
});

kadokawaTaiwan.addEventListener("click", function () {
    const bookUrl = "http://localhost:8080/books/tw?publisher_tw=台灣角川";
    getBook(bookUrl);
});

chingWin.addEventListener("click", function () {
    const bookUrl = "http://localhost:8080/books/tw?publisher_tw=青文出版";
    getBook(bookUrl);
});

sharpPoint.addEventListener("click", function () {
    const bookUrl = "http://localhost:8080/books/tw?publisher_tw=尖端";
    getBook(bookUrl);
});

tongLi.addEventListener("click", function () {
    const bookUrl = "http://localhost:8080/books/tw?publisher_tw=東立";
    getBook(bookUrl);
});

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
                <div class="book-image"></div>
                <div class="book-info">
                    <h3 class="title-tw">${book.title_tw}</h3>
                    <p class="title-jp font-jp">${book.title_jp}</p>
                    <p class="author font-jp">${book.author}</p>
                    <div class="publishing-info">
                        <div class="publishing-info-jp">
                            <p class="publisher font-jp">${book.publisher_jp}</p>
                            <p class="published-date">${book.published_date_jp}</p>
                            <p class="isbn">${book.isbn_jp}</p>
                        </div>
                        <div class="vertical-line"></div>
                        <div class="publishing-info-tw">
                            <p class="publisher">${book.publisher_tw}</p>
                            <p class="published-date">${book.published_date_tw}</p>
                            <p class="isbn">${book.isbn_tw}</p>
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