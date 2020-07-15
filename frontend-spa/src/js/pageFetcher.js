export {
    fetchPage
}

const fetchPage = async () => {
    return fetch('http://taco-randomizer.herokuapp.com/random/')
        .then(response => response.json())
}