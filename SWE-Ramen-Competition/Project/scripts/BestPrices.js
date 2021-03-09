//Author: Jeanette Eldredge
var allData = [];

const url = 'https://raw.githubusercontent.com/eldredgj10/Personal_Projects/master/SWE-Ramen-Competition/Project/api/BestPrices.json';
fetch(url)
    .then((response) => {
    if (response.ok) {
        return response.json();
    }
    else {
        console.log(error);
    }
})
    .then((response) => {
        allData = response;
    });


function output()
{
    allData.forEach(element => {
        const html = `<article> <h2>${element.Store}</h2> <h3>${element.Price} for ${element.Amount}</h3> <img src = "${element.imageURL}"> </article>`;
        document.querySelector('#StorePrice').innerHTML += html;
    });
}

const button = document.querySelector('#activate');
button.addEventListener('click', output)
