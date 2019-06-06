/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var cnpj = document.getElementById('empresa-view:cnpj');
var razao_social = document.getElementById('empresa-view:razao_social');
var nome_fantasia = document.getElementById('empresa-view:nome_fantasia');
var proprietario = document.getElementById('empresa-view:proprietario');
var cep = document.getElementById('empresa-view:cep');
var endereco = document.getElementById('empresa-view:endereco');
var numero = document.getElementById('empresa-view:numero');
var complemento = document.getElementById('empresa-view:complemento');
var bairro = document.getElementById('empresa-view:bairro');
var cidade = document.getElementById('empresa-view:cidade');
var estado = document.getElementById('empresa-view:estado');
var telefone_celular = document.getElementById('empresa-view:telefone_celular');
var email = document.getElementById('empresa-view:email');
var buttonSalvar = document.getElementById('empresa-view:button-save');

// Garante que os campos não serão editaveis no momento que a página é recarregada.
cnpj.readOnly = true;
razao_social.readOnly = true;
nome_fantasia.readOnly = true;
proprietario.readOnly = true;
cep.readOnly = true;
endereco.readOnly = true;
numero.readOnly = true;
complemento.readOnly = true;
bairro.readOnly = true;
cidade.readOnly = true;
estado.readOnly = true;
telefone_celular.readOnly = true;
email.readOnly = true;
buttonSalvar.disabled = true;

// Muda a cor do banner da empresa dependendo do primeiro número do CNPJ (de 0 a 9)
var red = "#a30000";
var orange = "orange";
var blue = "#7390cc";
var yellow = "#ffe65b";
var green = "#249a00";
var purple = "#8e53d6";
var pink = "#d953bb";
var brown = "#743838";
var grey = "#6b6b6b";
var black = "#323232"

var header = document.getElementById('header');
var title1 = document.getElementById('title1');
var title2 = document.getElementById('title2');

switch(parseInt(cnpj.value.charAt(0))) {
    case 0:
        header.style.backgroundColor = red;
        title1.style.borderColor = red;
        title2.style.borderColor = red;
        break;
    case 1:
        header.style.backgroundColor = orange;
        title1.style.borderColor = orange;
        title2.style.borderColor = orange;
        break;
    case 2:
        header.style.backgroundColor = blue;
        title1.style.borderColor = blue;
        title2.style.borderColor = blue;
        break;        
    case 3:
        header.style.backgroundColor = yellow;
        title1.style.borderColor = yellow;
        title2.style.borderColor = yellow;
        break; 
    case 4:
        header.style.backgroundColor = green;
        title1.style.borderColor = green;
        title2.style.borderColor = green;
        break; 
    case 5:
        header.style.backgroundColor = purple;
        title1.style.borderColor = purple;
        title2.style.borderColor = purple;
        console.log("entrou");
        break; 
    case 6:
        header.style.backgroundColor = pink;
        title1.style.borderColor = pink;
        title2.style.borderColor = pink;
        break; 
    case 7:
        header.style.backgroundColor = brown;
        title1.style.borderColor = brown;
        title2.style.borderColor = brown;
        break; 
    case 8:
        header.style.backgroundColor = grey;
        title1.style.borderColor = grey;
        title2.style.borderColor = grey;
        break; 
    case 9:  
        header.style.backgroundColor = black;
        title1.style.borderColor = black;
        title2.style.borderColor = black;

}
//---------------------------------------------------------------------------------

function salvar() {
    if(razao_social.readOnly === true) {
        razao_social.readOnly = false;
        nome_fantasia.readOnly = false;
        proprietario.readOnly = false;
        cep.readOnly = false;
        endereco.readOnly = false;
        numero.readOnly = false;
        complemento.readOnly = false;
        bairro.readOnly = false;
        cidade.readOnly = false;
        estado.readOnly = false;
        telefone_celular.readOnly = false;
        email.readOnly = false;
        buttonSalvar.disabled = false;
    }
    else {
        razao_social.readOnly = true;
        nome_fantasia.readOnly = true;
        proprietario.readOnly = true;
        cep.readOnly = true;
        endereco.readOnly = true;
        numero.readOnly = true;
        complemento.readOnly = true;
        bairro.readOnly = true;
        cidade.readOnly = true;
        estado.readOnly = true;
        telefone_celular.readOnly = true;
        email.readOnly = true;
        buttonSalvar.disabled = true;
    }
}
