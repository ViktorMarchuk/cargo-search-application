async function autoHintCity(id, parentId) {
    const inputEl = document.getElementById(id);
    const inputVal = inputEl.value;
    if (inputVal.length === 0) {
        removeAutoCompliteDropDown();
        return;
    }
    try {
        const response = await fetch(`/cargo/autocompleteCity?keyword=${inputVal}`, {
            method: 'GET'
        });
        const countriesAsData = await response.json();
        console.log(countriesAsData);
        removeAutoCompliteDropDown();
        createAutoCompliteDropDown(countriesAsData, parentId, inputEl);
    } catch (error) {
        console.error('Ошибка при получении стран:', error);
    }

    function createAutoCompliteDropDown(countriesAsData, parentId, inputEl) {
        const listEl = document.createElement("ul");
        listEl.id = "auto-complite-list";
        countriesAsData.forEach(country => {
            const listItem = document.createElement("li");
            const countryButton = document.createElement("button");
            countryButton.type = "button";
            countryButton.className = "autocomplete-button";
            countryButton.innerHTML = country;
            countryButton.addEventListener("click", function () {
                inputEl.value = countryButton.innerHTML;
                removeAutoCompliteDropDown();
            });
            listItem.appendChild(countryButton);
            listEl.appendChild(listItem);
        });
        document.body.appendChild(listEl);

        listEl.style.position = "absolute";
        listEl.style.zIndex = "1000";
        listEl.style.backgroundColor = "grey";
        listEl.style.border = "1px solid #ced4da";
        listEl.style.borderRadius = "15px";
        listEl.style.padding = "10px";
        listEl.style.margin = "5";
        listEl.style.top = `${inputEl.offsetTop + inputEl.offsetHeight}px`;
        listEl.style.left = `${inputEl.offsetLeft}px`;
    }

    function removeAutoCompliteDropDown() {
        const listEl = document.querySelector("#auto-complite-list");
        if (listEl) listEl.remove();
    }
}
