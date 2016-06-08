# coding=utf-8
"""
第一段程序 异常处理
"""
"""while True:
    try:
        x = input("Enter x:")
        y = input("Enter y:")
        value = x / y
        print "x/y is ", value
    except:
        print ("0做除数了")
    else:
        break
    finally:
        print ("这是最后一句")"""


'''第三段程序 stack
stack = [3,4,5]
stack.append(6)
print stack'''


"""第四段程序 代码调试
for i in range(10):
    a = i
    print a"""


"""第五段程序"""
'''import requests
html = requests.get('http://www.scut.edu.cn/jw2005/')
print html.text'''


""" #-*_coding:utf8-*-
import requests
import re
import sys
reload(sys)
sys.setdefaultencoding("utf-8")

class spider(object):
    def __init__(self):
        print u'开始爬取内容。。。'

#getsource用来获取网页源代码
    def getsource(self,url):
        html = requests.get(url)
        return html.text

#changepage用来生产不同页数的链接
    def changepage(self,url,total_page):
        now_page = int(re.search('pageNum=(\d+)',url,re.S).group(1))
        page_group = []
        for i in range(now_page,total_page+1):
            link = re.sub('pageNum=\d+','pageNum=%s'%i,url,re.S)
                page_group.append(link)
        return page_group
#geteveryclass用来抓取每个课程块的信息
    def geteveryclass(self,source):
        everyclass = re.findall('(<li deg="".*?</li>)',source,re.S)
        return everyclass
#getinfo用来从每个课程块中提取出我们需要的信息
    def getinfo(self,eachclass):
        info = {}
        info['title'] = re.search('target="_blank">(.*?)</a>',eachclass,re.S).group(1)
        info['content'] = re.search('</h2><p>(.*?)</p>',eachclass,re.S).group(1)
        timeandlevel = re.findall('<em>(.*?)</em>',eachclass,re.S)
        info['classtime'] = timeandlevel[0]
        info['classlevel'] = timeandlevel[1]
        info['learnnum'] = re.search('"learn-number">(.*?)</em>',eachclass,re.S).group(1)
        return info
#saveinfo用来保存结果到info.txt文件中
    def saveinfo(self,classinfo):
        f = open('info.txt','a')
        for each in classinfo:
            f.writelines('title:' + each['title'] + '\n')
            f.writelines('content:' + each['content'] + '\n')
                f.writelines('classtime:' + each['classtime'] + '\n')
            f.writelines('classlevel:' + each['classlevel'] + '\n')
            f.writelines('learnnum:' + each['learnnum'] +'\n\n')
        f.close()

if __name__ == '__main__':

    classinfo = []
    url = 'http://www.jikexueyuan.com/course/?pageNum=1'
    jikespider = spider()
    all_links = jikespider.changepage(url,20)
    for link in all_links:
        print u'正在处理页面：' + link
        html = jikespider.getsource(link)
        everyclass = jikespider.geteveryclass(html)
        for each in everyclass:
            info = jikespider.getinfo(each)
            classinfo.append(info)
    jikespider.saveinfo(classinfo)  """



"""第六段程序  xpath的一般用法
#-*_coding:utf8-*-
import sys
reload(sys)
sys.setdefaultencoding("utf-8")

from lxml import etree
html = '''
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>测试-常规用法</title>
</head>
<body>
<div id="content">
    <ul id="useful">
        <li>这是第一条信息</li>
        <li>这是第二条信息</li>
        <li>这是第三条信息</li>
    </ul>
    <ul id="useless">
        <li>不需要的信息1</li>
        <li>不需要的信息2</li>
        <li>不需要的信息3</li>
    </ul>

    <div id="url">
        <a href="http://jikexueyuan.com">极客学院</a>
        <a href="http://jikexueyuan.com/course/" title="极客学院课程库">点我打开课程库</a>
    </div>
</div>

</body>
</html>
'''

selector = etree.HTML(html)

#提取文本
content = selector.xpath('//ul[@id="useful"]/li/text()')
for each in content:
    print each

#提取属性
link = selector.xpath('//a/@href')
for each in link:
    print each

title = selector.xpath('//a/@title')
print title[0]"""


"""第七段程序 xpath的特殊用法
#-*-coding:utf8-*-

from lxml import etree

html1 = '''
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
    <div id="test-1">需要的内容1</div>
    <div id="test-2">需要的内容2</div>
    <div id="testfault">需要的内容3</div>
</body>
</html>
'''

html2 = '''
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
    <div id="test3">
        我左青龙，
        <span id="tiger">
            右白虎，
            <ul>上朱雀，
                <li>下玄武。</li>
            </ul>
            老牛在当中，
        </span>
        龙头在胸口。
    </div>
</body>
</html>
'''

selector = etree.HTML(html2)
content = selector.xpath('//div[starts-with(@id,"test")]/text()')
for each in content:
    print each

# selector = etree.HTML(html2)
# content_1 = selector.xpath('//div[@id="test3"]/text()')
# for each in content_1:
#     print each
#
#
# data = selector.xpath('//div[@id="test3"]')[0]
# info = data.xpath('string(.)')
# content_2 = info.replace('\n','').replace(' ','')
# print content_2
"""


"""第八段程序  python并行化"""
#-*-coding:utf8-*-
import pool
from multiprocessing.dummy import Pool as ThreadPool
import requests
import time

def getsource(url):
    html = requests.get(url)

urls = []

for i in range(1, 21):
    newpage = 'http://tieba.baidu.com/p/3522395718?pn=' + str(i)
    urls.append(newpage)

time1 = time.time()
for i in urls:
    print i
    getsource(i)
time2 = time.time()
print u'单线程耗时：' + str(time2-time1)

pool = ThreadPool(4)
time3 = time.time()
results = pool.map(getsource, urls)
pool.close()
pool.join()
time4 = time.time()
print u'并行耗时：' + str(time4-time3)


"""第九段程序  爬百度贴吧内容"""
"""#-*-coding:utf8-*-
from lxml import etree
from multiprocessing.dummy import Pool as ThreadPool
import requests
import json
import sys

reload(sys)

sys.setdefaultencoding('utf-8')

'''重新运行之前请删除content.txt，因为文件操作使用追加方式，会导致内容太多。'''

def towrite(contentdict):
    f.writelines(u'回帖时间:' + str(contentdict['topic_reply_time']) + '\n')
    f.writelines(u'回帖内容:' + unicode(contentdict['topic_reply_content']) + '\n')
    f.writelines(u'回帖人:' + contentdict['user_name'] + '\n\n')

def spider(url):
    html = requests.get(url)
    selector = etree.HTML(html.text)
    content_field = selector.xpath('//div[@class="l_post l_post_bright "]')
    item = {}
    for each in content_field:
        reply_info = json.loads(each.xpath('@data-field')[0].replace('&quot',''))
        author = reply_info['author']['user_name']
        content = each.xpath('div[@class="d_post_content_main"]/div/cc/div[@class="d_post_content j_d_post_content "]/text()')[0]
        reply_time = reply_info['content']['date']
        print content
        print reply_time
        print author
        item['user_name'] = author
        item['topic_reply_content'] = content
        item['topic_reply_time'] = reply_time
        towrite(item)

if __name__ == '__main__':
    pool = ThreadPool(4)
    f = open('content.txt', 'a')
    page = []
    for i in range(1, 3):
        newpage = 'http://tieba.baidu.com/p/3522395718?pn=' + str(i)
        page.append(newpage)

    results = pool.map(spider, page)
    pool.close()
    pool.join()
    f.close()"""

