// Mostrar ou esconder informações do acompanhante
function verAcompanhante() {
    const inforAcomp = document.getElementById('info-acomp');   //Div com os campos do acompanhante
    const opcAcomp = document.querySelector('input[name="acomp-idoso"]:checked').value;  //Opção que o usuário escolher

    //Se a opção for não irá esconder
    if (opcAcomp === 'nao') {
        inforAcomp.style.display = 'none';
    } else {    //Se for sim mostrará
        inforAcomp.style.display = 'block';
    }
}
