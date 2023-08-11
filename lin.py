import numpy as np
import matplotlib.pyplot as plt
import random
def func(m, c, x):
    ycap = m * x + c
    return ycap

x = np.array([1.0, 2.0, 3.0, 4.0])
y = np.array([300, 500, 700, 900])
m = random.randint(0, 9)
c = random.randint(0, 9)
lr = 0.1
itrvalue = 500
costs=[]
weights=[]

for i in range(itrvalue):
    ycap = func(m, c, x)
    error = ycap - y
    cost = np.mean(error ** 2)
    costs.append(cost)
    m_deriv = 2 * np.mean(error * x)
    c_deriv = 2 * np.mean(error)
    m = m - m_deriv * lr
    c = c - c_deriv * lr
    weights.append((m))

print("Final cost:", cost)
print("Final weights (m, c):", m, c)
print(func(m,c,x))
plt.scatter(x,y)
plt.show()
