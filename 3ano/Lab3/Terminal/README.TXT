PROJECT TITLE: Terminal
PURPOSE OF PROJECT: Exercícios com as classes Java que tratam arquivos e diretórios. 
VERSION or DATE: 22/02/2017
HOW TO START THIS PROJECT: Comecem do começo! :P
USER INSTRUCTIONS: Vocês devem implementar no Terminal alguns comandos. Neste programa, estaremos
                    emulando o funcionamento de um terminal. Uma parte de leitura, dos comandos
                    esta implementado, mas fiquem a vontade para alterar o que acharem necessário.
                    Os comandos: ajuda, onde e sair estão funcionando, para exemplificar como o Scanner
                    esta tratando os comando de entrada. O onde apresenta de forma simplificada, a
                    utilização do Path.
                    
                    Vocês devem implementar os seguintes comando:

                  listar: lista todos os arquivos que se encontram no diretório atual.
                    
                        > listar 
                        Documentos  
                        Downloads   
                        log.txt     
                        script      
                    
                    listar info: lista todos os arquivos e diretórios que se encontram no
                                 diretório atual bem como as seguintes informações dos metadados.
                                 As informações do metadados que são mostradas são:
                                 Nome do arquivo, usuário, tamanho, permissão de leitura, permissão
                                 de escrita, permissão de execução, e última data de modificação.
                                 O sinal (+) indica que é possível ler, escrever ou executar, o 
                                 o sinal (-) indica o contrário. Se não for possível fazer a leitura,
                                 o sinal (*) deve ser utilizado.
                                 
                                > listar info
                                Documentos  (user)  500MiB  L(+) E(+) X(-)   22 Fev 2017
                                Downloads   (user)  3GiB    L(+) E(+) X(-)   22 Fev 2017
                                log.txt     (user)  1kiB    L(+) E(+) X(-)   22 Fev 2017
                                script      (user)  1kiB    L(-) E(-) X(-)   22 Fev 2017                                
                                 
                    criar: cria um diretório ou arquivo, depende do argumento passado.
                           criar d nome_diretorio - cria um diretório 
                           criar a nome_arquivo - cria um arquivo 
                           
                           > criar d teste
                           Diretório "teste" criado!
                           
                           > criar a teste.txt
                           Arquivo teste.txt criado!                                                      
                           
                    copiar: comando para copiar um arquivo de um diretório para outro. 
                            Para utilizar, o usuário deve passar como primeiro argumento o 
                            arquivo, e como segundo argumento o local que deseja mover.
                            
                            > copiar teste.txt /home/user/downloads
                            Arquivo copiado com sucesso!
                        
                    mover: comando para mover um arquivo de um diretório para outro.
                           Para utilizar, o usuário deve passar como primeiro argumento o 
                           arquivo, e como segundo argumento o local que deseja mover. 

                            > mover teste.txt /home/user/downloads
                            Arquivo movido com sucesso!                           
                           
                    mudar: comando para mudar de um diretório para outro.
                           Para utilizar, o usuário deve passar como argumento o
                           o local que deseja se mover. 
                           
                           > mudar ..
                           Mudando para /home/user/downloads
                           > mudar ..
                           Mudando para /home/user
                           > mudar downloads
                           Mudando para /home/user/downloads                           
                           
                    onde: mostra o diretório atual.
                    
                        > onde
                        /user/home/Downloads
                        
                    sair: finaliza o programa.