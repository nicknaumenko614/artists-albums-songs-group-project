export {
    fetchPage
}

const fetchPage = async () => {
    return fetch('http://localhost:8080/api/artists/')
        .then(response => response.json())
}