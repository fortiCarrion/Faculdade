#------------------------------------------------------------------------------
# AQUECIMENTO - LISTA 01
# AUTOR: JAIR CARRION
#
#------------------------------------------------------------------------------
#Exercicio 1
def fibonacci(entrada):
    """Metodo recursivo para retornar o fibonacci dado como parametro"""
    if entrada == 1 or entrada == 2:
        return 1
    return fibonacci(entrada-1)+fibonacci(entrada-2)

#------------------------------------------------------------------------------
#Exercicio 2
#a)
def sumLista(lista):
    """Metodo para calcular os valores dos index da lista como parametro"""
    return sum(lista)
#b)
def sumListaSegundoTerceiro(lista):
    """Metodo para calcular o segundo e terceior maior valores de uma lista"""
    lista = list(set(lista))
    sum = lista[len(lista) -2] + lista[len(lista) -3]
    return sum

# ------------------------------------------------------------------------------
# Exercicio 3
#a)
def quebraString(s,c):
    """Metodo que retorna uma string que contenha o conteúdo de s após a primeira aparição de c"""
    aux = ''
    encontrou = False
    for i in str(s):
        if i == c:
            encontrou = True
        if encontrou == True:
            aux+=str(i)
    return aux[1:]
#b)
def quebraStringDois(s,c):
    """"Metodo que retorna uma string que contenha o conteúdo de s após a última aparição de c"""
    aux = 0
    aux2 = 0
    retorno = ''
    for i in str(s):
        if i == c:
            aux += 1

    for i in str(s):
        if i == c:
            aux2 += 1
        if aux2 == aux:
            retorno += str(i)
    return retorno[1:]
#c)
def quebraStringTres(s,c):
    """Metodo que retorna uma string que contenha o conteúdo de s que conste entre a primeira e a última aparição de c"""
    aux = 0
    aux2 = 0
    retorno = ''
    for i in str(s):
        if i == c:
            aux += 1

    if aux % 2 != 0:
        print("O numero de ocorencias com o caractere 'c' foi impar, portanto nao se sabe onde eh o meio entre as divisoes de 'c' ")
    else:
        meio = aux / 2
        for i in str(s):
            if i == c:
                aux2 += 1
            if aux2 >= meio and aux2 < (meio+1):
                retorno += str(i)

        return retorno[1:]

# ------------------------------------------------------------------------------
# Exercicio 4
#a)
def palindromo(string):
    """Metodo que recebe uma String por parâmetro e verifica se trata-se de um palíndromo ou nao"""
    s = string
    i = 0
    f = len(s) - 1  # posição do último caracter da string
    while f > i and s[i] == s[f]:
        f = f - 1
        i = i + 1
    if s[i] == s[f]:
        print("{} é palíndromo".format(s))
    else:
        print("{} não é palíndromo".format(s))
#b)
def palindromoSemEspaco(string):
    """Metodo que recebe uma String por parâmetro eliminando os espacos em branco e verifica se trata-se de um palíndromo ou nao"""
    s = string.replace(" ", "")
    palindromo(s)

# ------------------------------------------------------------------------------
# Exercicio 5
#a)
def listaPalindromo(lista):
    """Metodo que recebe uma lista por parâmetro eliminando os espacos em branco e verifica se trata-se de um palíndromos ou nao"""
    print(lista)
    for conteudo in lista:
        palindromo(conteudo)

#b)
def listaParesPalindromos():
    """"Metodo que imprime todos os números pares de 1 a 10000 que são palíndromos"""
    tamanho = 10001
    lista_aux = [ x for x in range(1, tamanho)if x % 2 == 0]
    listaPalindromo(lista_aux)

##################################################################################
#####################         RESULTADOS           ###############################
##################################################################################
#
#lista = [5,8,9,10,15,10,5,5,3,3,1,0,2,5,4,6,7]
#print ("Fibonacci de 12: {}".format(fibonacci(12)))
#print("Soma da lista: {}".format(sumLista(lista)))
#print("Soma do segundo: {} e terceiro: {}, valores da lista eh igual: {}".format(ex2_1, ex2_2, sumListaSegundoTerceiro(lista)))
#print(quebraString("EU, AMO MEU MUNDO", ","))
#print(quebraStringDois("tes,te, , sdad ,teste",","))
#print(quebraStringTres("eu, gosto de, ihc",","))
#palindromo("OMISSISSIMO")
#palindromoSemEspaco("ROMA ME TEM AMOR")
#lista_palindromos = ["OMISSISSIMO", "454", "158947", "remommendation"]
#listaPalindromo(lista_palindromos)
#listaParesPalindromos()
##################################################################################
