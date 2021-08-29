const nowList = document.getElementById('todo-nowList');

const getUserToDoList = async () => {
    nowList.innerHTML = "List1"
    const url = '/api/todo'
    let fetchResponse = await (await fetch(url).catch(fetchError));
    
    if(fetchResponse.status !== 200){
        console.log("200이 아님!");
        return ;
    }
    const result = await fetchResponse.json();
    
    if(!Array.isArray(result.data)) {
        console.log("배열이 아님!");
        return ;
    }

    nowList.innerHTML = result.data.map(element => 
        `<div class="nowList-one">
            <div class="nowList-one-id">
                ${element.id}
            </div>
            <div class="nowList-one-content">
                ${element.content}
            </div>
        </div>`
        ).join('')
}

const fetchError = (err) => {
    console.warn(err);
}

const init = async () => {
    await getUserToDoList();
}

init()