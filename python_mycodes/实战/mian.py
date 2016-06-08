#coding=utf-8
"""import urllib2
response = urllib2.urlopen('http://www.baidu.com/')
html = response.read()
print html"""
import requests
html = requests.get('http://www.baidu.com/')
html.encoding = 'utf-8'
print html.text

