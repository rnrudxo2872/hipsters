import {borderColorChange} from '../cssEvent.js'

const inputToDo = document.getElementById('todo-insertBox__content');
const focusBtn = document.querySelector('.focus-insert');

const focusBorderChangeEvent = (event) => {
    console.log(event.target.parentElement);
    borderColorChange(event.target.parentElement, 'rgba(131, 191, 247, 0.836)');
}

const focusOutBorderChangeEvent = (event) => {
    borderColorChange(event.target.parentElement, '#fff');
}

const createUserToDo = async (event) => {
    
    if(event.key === 'Enter'){
        const url = '/api/todo'
        const body = {
            content:event.target.value,
        }
        const reqData = {
            method:'POST',
            headers:{
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        }

        const result = await (await fetch(url,reqData)).json()
        event.target.value = '';
    }
}

inputToDo.addEventListener('focus', focusBorderChangeEvent, true)
inputToDo.addEventListener('focusout', focusOutBorderChangeEvent)
inputToDo.addEventListener('keyup', createUserToDo)
focusBtn.addEventListener('click', (_) => inputToDo.focus())