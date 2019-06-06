/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var matricula = document.getElementById('funcionario-view:matricula');
var nome = document.getElementById('funcionario-view:nome');
var sobrenome = document.getElementById('funcionario-view:sobrenome');
var sexo = document.getElementById('funcionario-view:sexo');
var rg = document.getElementById('funcionario-view:rg');
var cpf = document.getElementById('funcionario-view:cpf');
var nome_pai = document.getElementById('funcionario-view:nome_pai');
var nome_mae = document.getElementById('funcionario-view:nome_mae');
var nascimento = document.getElementById('funcionario-view:nascimento');
var estado_civil = document.getElementById('funcionario-view:estado_civil');
var nacionalidade = document.getElementById('funcionario-view:nacionalidade');
var grau_instrucao = document.getElementById('funcionario-view:grau_instrucao');
var raca = document.getElementById('funcionario-view:raca');
var cep = document.getElementById('funcionario-view:cep');
var endereco = document.getElementById('funcionario-view:endereco');
var endereco_numero = document.getElementById('funcionario-view:endereco_numero');
var endereco_complemento = document.getElementById('funcionario-view:endereco_complemento');
var bairro = document.getElementById('funcionario-view:bairro');
var cidade = document.getElementById('funcionario-view:cidade');
var estado = document.getElementById('funcionario-view:estado');
var telefone_celular = document.getElementById('funcionario-view:telefone_celular');
var telefone_fixo = document.getElementById('funcionario-view:telefone_fixo');
var email = document.getElementById('funcionario-view:email');
var cargo = document.getElementById('funcionario-view:cargo');
var data_contratacao = document.getElementById('funcionario-view:data_contratacao');
var tipo_contratacao = document.getElementById('funcionario-view:tipo_contratacao');
var periodo_atuacao = document.getElementById('funcionario-view:periodo_atuacao');
var id_empresa = document.getElementById('funcionario-view:id_empresa');
var buttonSalvar = document.getElementById('funcionario-view:button-save');

// Garante que os campos não serão editaveis no momento que a página é recarregada.

matricula.readOnly = true;
nome.readOnly = true;
sobrenome.readOnly = true;
sexo.disabled = true;
rg.readOnly = true;
cpf.readOnly = true;
nome_pai.readOnly = true;
nome_mae.readOnly = true;
nascimento.readOnly = true;
estado_civil.disabled = true;
nacionalidade.readOnly = true;
grau_instrucao.disabled = true;
raca.disabled = true;
cep.readOnly = true;
endereco.readOnly = true;
endereco_numero.readOnly = true;
endereco_complemento.readOnly = true;
bairro.readOnly = true;
cidade.readOnly = true;
estado.readOnly = true;
telefone_celular.readOnly = true;
telefone_fixo.readOnly = true;
email.readOnly = true;
cargo.readOnly = true;
data_contratacao.readOnly = true;
tipo_contratacao.disabled = true;
periodo_atuacao.disabled = true;
id_empresa.disabled = true;
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
var title3 = document.getElementById('title3');

switch(parseInt(matricula.value.charAt(0))) {
    case 0:
        header.style.backgroundColor = red;
        title1.style.borderColor = red;
        title2.style.borderColor = red;
        title3.style.borderColor = red;
        break;
    case 1:
        header.style.backgroundColor = orange;
        title1.style.borderColor = orange;
        title2.style.borderColor = orange;
        title3.style.borderColor = orange;
        break;
    case 2:
        header.style.backgroundColor = blue;
        title1.style.borderColor = blue;
        title2.style.borderColor = blue;
        title3.style.borderColor = blue;
        break;        
    case 3:
        header.style.backgroundColor = yellow;
        title1.style.borderColor = yellow;
        title2.style.borderColor = yellow;
        title3.style.borderColor = yellow;
        break; 
    case 4:
        header.style.backgroundColor = green;
        title1.style.borderColor = green;
        title2.style.borderColor = green;
        title3.style.borderColor = green;
        break; 
    case 5:
        header.style.backgroundColor = purple;
        title1.style.borderColor = purple;
        title2.style.borderColor = purple;
        title3.style.borderColor = purple;
        console.log("entrou");
        break; 
    case 6:
        header.style.backgroundColor = pink;
        title1.style.borderColor = pink;
        title2.style.borderColor = pink;
        title3.style.borderColor = pink; 
        break; 
    case 7:
        header.style.backgroundColor = brown;
        title1.style.borderColor = brown;
        title2.style.borderColor = brown;
        title3.style.borderColor = brown; 
        break; 
    case 8:
        header.style.backgroundColor = grey;
        title1.style.borderColor = grey;
        title2.style.borderColor = grey;
        title3.style.borderColor = grey;
        break; 
    case 9:  
        header.style.backgroundColor = black;
        title1.style.borderColor = black;
        title2.style.borderColor = black;
        title3.style.borderColor = black;

}
//---------------------------------------------------------------------------------

function salvar() {
    if(nome.readOnly === true) {
        nome.readOnly = false;
        sobrenome.readOnly = false;
        sexo.disabled = false;
        rg.readOnly = false;
        cpf.readOnly = false;
        nome_pai.readOnly = false;
        nome_mae.readOnly = false;
        nascimento.readOnly = false;
        estado_civil.disabled = false;
        nacionalidade.readOnly = false;
        grau_instrucao.disabled = false;
        raca.disabled = false;
        cep.readOnly = false;
        endereco.readOnly = false;
        endereco_numero.readOnly = false;
        endereco_complemento.readOnly = false;
        bairro.readOnly = false;
        cidade.readOnly = false;
        estado.readOnly = false;
        telefone_celular.readOnly = false;
        telefone_fixo.readOnly = false;
        email.readOnly = false;
        cargo.readOnly = false;
        data_contratacao.readOnly = false;
        tipo_contratacao.disabled = false;
        id_empresa.disabled = false;
        periodo_atuacao.disabled = false;
        buttonSalvar.disabled = false;
    }
    else {
        matricula.readOnly = true;
        nome.readOnly = true;
        sobrenome.readOnly = true;
        sexo.disabled = true;
        rg.readOnly = true;
        cpf.readOnly = true;
        nome_pai.readOnly = true;
        nome_mae.readOnly = true;
        nascimento.readOnly = true;
        estado_civil.disabled = true;
        nacionalidade.readOnly = true;
        grau_instrucao.disabled = true;
        raca.disabled = true;
        cep.readOnly = true;
        endereco.readOnly = true;
        endereco_numero.readOnly = true;
        endereco_complemento.readOnly = true;
        bairro.readOnly = true;
        cidade.readOnly = true;
        estado.readOnly = true;
        telefone_celular.readOnly = true;
        telefone_fixo.readOnly = true;
        email.readOnly = true;
        cargo.readOnly = true;
        data_contratacao.readOnly = true;
        tipo_contratacao.disabled = true;
        periodo_atuacao.disabled = true;
        id_empresa.disabled = true;
        buttonSalvar.disabled = true;
    }
}
