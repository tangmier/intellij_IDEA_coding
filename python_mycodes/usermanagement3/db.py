#encoding=utf-8
#使用python，用户向数据库中插入数据
import MySQLdb

#connect to db
conn = MySQLdb.connect("localhost", "root", "123456", "test")

#create cursor
cur = conn.cursor()


def addUser(username, password):
    sql = "insert into user (username,password) VALUES ('%s', '%s' )"%(username,password)
    cur.execute(sql)
    conn.commit()     #为了防止数据不一致情况的
    conn.close()


def isExisted(username, password):
    # sql = "select * from user where username ='%s' and password ='%s'" %(username,password)
    sql = "select * from user where username="+username+"and password="+password
    cur.execute(sql)
    result = cur.fetchall()
    if (len(result) == 0):   #通过判断返回结果长度是否为0来判断是否存在与数据库中
        return False
    else:
        return True




