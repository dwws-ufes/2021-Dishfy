/** Implementado com base em: 
 * https://www.youtube.com/watch?v=BLe27Zukmwo&ab_channel=SatellaSoft
 * https://www.youtube.com/watch?v=ZbbwP3Yz2dg&ab_channel=SatellaSoft */

let photo = document.getElementById('img-profile');
let file = document.getElementById('file-profile');

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