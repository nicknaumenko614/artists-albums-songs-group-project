import {
    fetchPage
} from "./pageFetcher";


const renderAllArtists = (element, artists) => {
    clearElementChildren(element);

    for (let i = 0; i < artists.length; i++) {
        const article = document.createElement('article');
        article.classList.add('artist');
        article.innerHTML = `
            <h2 class="vendor__title">${vendors[i].name}</h2>
            <h4 class="vendor__phone-number">${vendors[i].phoneNumber}</h4>            
        `;

        article.addEventListener('click', () => {
            renderVendor(element, vendors[i]);
        });
        element.append(article);
    };