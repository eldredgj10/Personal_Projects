//Author: Jeanette Eldredge
var allData = [];

const url = 'https://raw.githubusercontent.com/eldredgj10/Personal_Projects/master/SWE-Ramen-Competition/Project/api/Recipes.json';
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

function reset()
{
    document.querySelector('#Recipes').innerHTML = '';
}

function sortBy()
{
    var selection = document.getElementById('sortBy').value;

    if (selection == "All")
    {
        reset();
        allData.forEach(element => { output(element); });
    }
    else if (selection == "Soups")
    {
        reset();
        allData.forEach(element => {
            if (element.Type == "Soup") {
                output(element);
            }
        });
    }
    else if (selection == "Salads")
    {
        reset();
        allData.forEach(element => {
            if (element.Type == "Salad") {
                output(element);
            }
        });
    }
    else {
        reset();
        allData.forEach(element => {
            if (element.Type == "Main dish") {
                output(element);
            }
        });
    }
}

function output(element)
{
    const html = `<article> <h3>${element.Name}</h3> <url>${element.location}</url> <img src = "${element.imageURL}"> </article>`;
    document.querySelector('#Recipes').innerHTML += html;
}

const select = document.querySelector('#sortBy');
select.addEventListener('click', sortBy);