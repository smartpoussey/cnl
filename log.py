import numpy as np
import pandas as pd
import statsmodels.api as sm

spending = [2.291, 3.215, 2.135, 3.924, 2.528, 2.473, 2.384, 7.076, 1.182, 3.345]
card = [1, 1, 1, 0, 1, 0, 0, 0, 1, 0]
coupon = [1, 0, 1, 0, 0, 1, 0, 0, 1, 0]

data = pd.DataFrame({'Spending': spending, 'HasCreditCard': card, 'CouponUsage': coupon})
data['Intercept'] = 1

logit_model = sm.Logit(data['CouponUsage'], data[['Intercept', 'Spending', 'HasCreditCard']])
result = logit_model.fit()

print(result.summary())

spending_amount = float(input("Enter the amount spent: "))
has_credit_card = int(input("Enter whether the user has a credit card (0/1): "))

user_data = {'Intercept': 1, 'Spending': spending_amount, 'HasCreditCard': has_credit_card}

prediction = result.predict(user_data)[0]

threshold = 0.5

if prediction > threshold:
    print("The user is likely to use the coupon.")
else:
    print("The user is unlikely to use the coupon.")
