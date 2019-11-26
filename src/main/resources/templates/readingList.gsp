<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reading List</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <form method="POST" action="/logout">
        <input type="submit" value="Logout"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>

    <h2><g:if test="${reader.fullname != null}"><span>${reader.fullname}</span></g:if>
        <g:else><span></span></g:else>
        's Reading List</h2>
    <g:if test="${books}">
        <g:each in="${books}" var="book">
            <dl>
                <dt class="bookHeadline">
                    <a href=" 'http://www.amazon.com/gp/product/${book.isbn}/tag=${amazonID}">${book.title}</a> by ${book.author}
                    (ISBN:${book.isbn})
                </dt>
                <dd class="bookDescription">
                    <g:if="book.description">${book.description}</g:if>
                    <g:else>No description available</g:else>
                </dd>
            </dl>
        </g:each>
    </g:if>
    <g:else>
        <p>You have no books in your book list</p>
    </g:else>

    <hr/>

    <h3>Add a book</h3>
    <form method="POST" action="/">
        <label for="title">Title:</label>
        <input type="text" name="title" value="${book?.title}"></input><br />
        <label for="author">Author:</label>
        <input type="text" name="author" value="${book?.author}"></input><br/>
        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" vlaue="${book?.isbn}"></input><br/>
        <label for="description">Description:</label><br/>
        <textarea name="description" cols="80" rows="5">${book?.description}</textarea><br/>
        <input type="submit" value="Add Book"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</body>
</html>
