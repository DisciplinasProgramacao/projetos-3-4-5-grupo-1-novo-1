# Projeto 4 - Gestão de Frota (parte 2)

## Nota: 16,7

## Comentários
	- Modularizar a lógica de vocês no switch principal. O case 4, por exemplo, é impossível compreender. 
	
## Correção

### Modelagem: 1,2/2   
	- Modularização de tanque e combustível
	
### Requisitos dos veículos, de acordo com a modelagem: 6,5/9  
	- Restrição de combustível: 1,8/3 -- existe, mas uso ferindo LSP (Grave)
	- Abastecimento e autonomia: 2,2/3 -- existe, mas a rota não fica no veículo e a frota está realizando a modificação na classe veículo. Não pode, isso é grave.
	- Custos fixos e variáveis: 2,5/3  -- sem validação de custo (entra negativo)
	
### Requisitos da empresa no programa principal: 9/9 
	- Quilometragem média das rotas da empresa: 3/3 
	- Filtro para busca de rotas por data: 3/3   (**muito bom, parabéns**)
	- Um dos dois abaixo: 3/3
		- Os 3 veículos que mais fizeram rotas 
		- Lista de veículos ordenada decrescentemente por custos gerados 
	

