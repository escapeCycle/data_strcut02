# coding=gbk
import requests
import logging
import time 

url = "http://www.jubi.com/"

api = "api/v1/ticker"

coin = "ans"
payload = {"coin":coin}

for i in range(1, 10000):
    res = requests.get(url + api, params = payload)

    ticker = res.json()

    msg = "%.2f" % float(ticker['last'])

    

    print time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()) + "\t\t" + msg

    time.sleep(10)
