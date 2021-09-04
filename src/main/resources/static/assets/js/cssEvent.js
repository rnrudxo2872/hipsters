export const borderColorChange = (element, colorCode) => {
    console.log(element?.style?.borderColor);
    if(element?.style?.borderColor !== undefined){
        element.style.borderColor = colorCode;
        return true;
    }
    return false;
}