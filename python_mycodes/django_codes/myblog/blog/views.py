# from django.shortcuts import render
from blog.models import BlogPost
from django.shortcuts import render_to_response
# from django.http import HttpResponse
# from django.template import loader, Context


# Create your views here.
def index(request):
    # posts = BlogsPost.objects.all()
    # t = loader.get_template("index.html")
    # c = Context({'post': posts})
    # return HttpResponse(t.render(c))
    blog_list = BlogPost.objects.all()
    return render_to_response('index.html', {'blog_list': blog_list})

