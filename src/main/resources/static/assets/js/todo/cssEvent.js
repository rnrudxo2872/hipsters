import {borderColorChange} from '../cssEvent.js'

const inputToDo = document.getElementById('todo-insertBox__content');

const focusBorderChangeEvent = (event) => {
    console.log(event.target.parentElement);
    borderColorChange(event.target.parentElement, 'rgba(131, 191, 247, 0.836)');
}

const focusOutBorderChangeEvent = (event) => {
    borderColorChange(event.target.parentElement, '#fff');
}

inputToDo.addEventListener('focus', focusBorderChangeEvent, true)
inputToDo.addEventListener('focusout', focusOutBorderChangeEvent)