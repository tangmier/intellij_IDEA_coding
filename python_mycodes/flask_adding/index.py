#coding=utf-8
from flask import Flask
from flask import render_template
from flask import url_for
from flask import request
from flask import redirect
app = Flask(__name__)   #实例化一个Flask类
@app.route('/', methods=['GET','POST'])  #index页面为首页
def index():
  # return "this is index"
    return redirect(url_for('add'))    #redirect的设置使得首页直接重定向到了add页面

@app.route('/add', methods=['GET','POST'])
def add():
    # message = 'Backend message'
    if request.method == 'POST':
        a = request.form['adder1']
        b = request.form['adder2']
        a = int(a)
        b = int(b)
        c = a+b
        return render_template('adding.html', message=str(c))
    return render_template('adding.html')
    # return "hello.Flask"
if __name__ == "__main__":
    app.run(port=8080)

