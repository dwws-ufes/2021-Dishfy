/** Implementado com base em: 
 * https://www.youtube.com/watch?v=BLe27Zukmwo&ab_channel=SatellaSoft
 * https://www.youtube.com/watch?v=ZbbwP3Yz2dg&ab_channel=SatellaSoft */

let photo = document.getElementById('imgReceita');
let file = document.getElementById('imagem-produto');

photo.addEventListener('click', () => {
    file.click();
});

file.addEventListener('change', (event) => {

    if (file.files.lenght <= 0) {
        return;
    }

    let reader = new FileReader();

    reader.onload = () => {
        photo.src = reader.result;
    }

    reader.readAsDataURL(file.files[0]);
});