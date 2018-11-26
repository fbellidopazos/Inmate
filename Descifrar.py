from random import randint


def code2(q):
    digits=[]
    x=digits.append((int(q/1000))%10)
    y=digits.append((int(q/100))%10)
    z=digits.append((int(q/10))%10)
    t=digits.append(q%10)
    return(digits)



digits=code2(1234)

Check=[False,False,False,False]
i=1
while(i<=4):
    
