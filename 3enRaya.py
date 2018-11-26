from random import randint
Matriz=[["","",""],["","",""],["","",""]]


condition=True

while(condition):
#Humano
    fila=int(input("Fila"))
    columna=int(input("Columna"))
    while(Matriz[fila][columna]==0 or Matriz[fila][columna]==1):
        print("No sabes jugar o que?")
        fila=int(input("Fila"))
        columna=int(input("Columna"))
    Matriz[fila][columna]=1
    if(Matriz[0][0]==Matriz[0][1]==Matriz[0][2]==1 or Matriz[1][0]==Matriz[1][1]==Matriz[1][2]==1 or Matriz[2][0]==Matriz[2][1]==Matriz[2][2]==1 or Matriz[0][0]==Matriz[1][0]==Matriz[2][0]==1 or Matriz[0][1]==Matriz[1][1]==Matriz[2][1]==1 or Matriz[0][2]==Matriz[1][2]==Matriz[2][2]==1 or Matriz[0][0]==Matriz[1][1]==Matriz[2][2]==1 or Matriz[0][2]==Matriz[1][1]==Matriz[2][0]==1):
        condition= False
        print("Humano Wins")
#IA
    filaIA=randint(0,2)
    columnaIA=randint(0,2)
    i=0
    while(i<2):
        while(Matriz[filaIA][columnaIA]==1):
            filaIA=randint(0,2)
            columnaIA=randint(0,2)
        Matriz[filaIA][columnaIA]=0
        filaIA=randint(0,2)
        columnaIA=randint(0,2)
        i+=1
    i=0
    if(Matriz[0][0]==Matriz[0][1]==Matriz[0][2]==0 or Matriz[1][0]==Matriz[1][1]==Matriz[1][2]==0 or Matriz[2][0]==Matriz[2][1]==Matriz[2][2]==0 or Matriz[0][0]==Matriz[1][0]==Matriz[2][0]==0 or Matriz[0][1]==Matriz[1][1]==Matriz[2][1]==0 or Matriz[0][2]==Matriz[1][2]==Matriz[2][2]==0 or Matriz[0][0]==Matriz[1][1]==Matriz[2][2]==0 or Matriz[0][2]==Matriz[1][1]==Matriz[2][0]==0):
        condition= False
        print("Machine Wins")
#Condition checkers


    print({}+"/"+{}+"\"+{}).format(Matriz[0][0],Matriz[0][1],Matriz[0][2])
    print("------------------")
    print(Matriz[1])
    print("------------------")
    print(Matriz[2])
