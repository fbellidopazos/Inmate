from random import randint


scoreh=0
scorem=0
win=0
machine=0
z=0
while z!=3:


    y = float(randint(1,3))
    x = float(input("1- Papel ; 2-Tijeras ; 3-Piedra"))

    if x != y:
        if (x == 1) and (y==2):
            scorem += float(1)
            print("La máquina ha ganado")
            machine+=1
        elif (x==2) and (y==3):
            scorem += float(1)
            print("La máquina ha ganado")
            machine+=1
        elif (x==3) and (y==1):
            scorem += float(1)
            print("La máquina ha ganado")
            machine+=1
        else:
            scoreh += float(1)
            win += 1
            z +=1
            print("Has ganado")
    else:
        print("Repetir")
    print(y)
input()
