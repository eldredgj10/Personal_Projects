//Author: Jeanette Eldredge
var allData = [];
var store = [];
var price = [];
var amount = [];
function organize(list)
{
    allData.forEach(element => {
        store.push(element.Store);
        price.push(element.Price);
        amount.push(element.Amount);
    });
    
}

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
        organize(allData);
    });


function reset()
{
    document.querySelector('#names').innerHTML = '';
}


function output(name)
{
    const html = `<h3>${name}</h3>`;
    document.querySelector('#names').innerHTML = html;
}

const button = document.querySelector('#Generate');
button.addEventListener('click', generate)
