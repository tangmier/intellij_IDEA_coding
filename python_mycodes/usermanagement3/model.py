#model.py
#coding=utf-8
from flask import Flask
from flask.ext.sqlalchemy import SQLAlchemy

app = Flask(__name__)
#在实例化db，也就是sqlalchemy的对象时时需要使用到app对象
app.config['SQLAlchemy_DATABASE_URL'] = "mysql://root:123456@localhost/test" #设定数据库目录
db = SQLAlchemy(app)


class User(db.Model):   #db.model数据库模型提供了增删改查的功能
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(32), unique=True)
    password = db.Column(db.String(32))

    def __init__(self, username, password):
        self.username = username
        self.password = password

    def add(self):
        try:
            db.session.add(self)
            db.session.commit()
            return self.id
        except Exception, e:
            db.session.rollback()
            return e
        finally:
            return 0

    def isExisted(self):
        temUser = User.query.filter_by(username=self.username, password=self.password).first()
        if temUser is None:
            return 0
        else:
            return 1


# class Entry(db.Model):
#     id = db.Column(db.Integer, primary_key=True)
#     content = db.Column(db.Text)
#     sender = db.Column(db.String(32))
#
#     def __init__(self, content, sender):
#         self.content = content
#         self.sender = sender
#
#     def add(self):
#         try:
#             db.session.add(self)
#             db.session.commit()
#             return self.id
#         except Exception, e:
#             db.session.rollback()
#             return e
#         finally:
#             return 0


def getAllEntry():
    Entlist = []
    Entlist = Entry.query.filter_by().all()
    return Entlist


