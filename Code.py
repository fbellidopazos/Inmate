from random import randint

def code(x):
    count=0
    res=""
    res2=""
    numAr=[]

    while(count<=x+2):
        y=x%10
        x=int(x/10)
        print(y)
        numAr.append(y)
        res=res+str(y)
        res2=str(y)+res2
        count+=1
    print(numAr)
    return(res +" "+ res2)


def code2(q):
    digits=[]
    t=digits.append(q%10)
    z=digits.append((int(q/10))%10)
    y=digits.append((int(q/100))%10)
    x=digits.append((int(q/1000))%10)
    return(x,y,z,t)
input("TEst")
x=randint(1000000,99999999)
print("Number is {}".format(x))
print(code(x))

x1,y1,z1,t1=code2(x)
print(str(x1)+str(y1)+str(z1)+str(t1))
