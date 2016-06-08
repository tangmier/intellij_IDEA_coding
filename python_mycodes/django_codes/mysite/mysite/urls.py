"""mysite URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.9/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""

# from books import views
# from books.views import search
# new lines
# from books.views import about_pages
# from django.views.generic.base import TemplateView
from django.conf.urls import url
from django.contrib import admin
# new line
from books.models import Publisher
from django.views.generic.list import ListView


urlpatterns = [
    url(r'^search/$', 'books.views.search'),
    url(r'^admin/', admin.site.urls),
    # new line
    url(r'publishers/$', ListView.as_view(model=Publisher,
                    context_object_name='publisher_list',
                    template_name='books/publisher_list_page.html')),
    ]
    #  url(r'^search-form/$', views.search_form),
    # url(r'^search/$', views.search),
    # url(r'^search/$', search),
    #  new line
    # url(r'^about/$', TemplateView.as_view(template_name='about.html')),
    # url(r'^about/(\w+)/$', about_pages),
  # ]
# from django.conf.urls import patterns, url
# from view import current_datetime, hours_ahead
#
# urlpatterns = patterns('',
#                        url(r'^time/$', current_datetime),
#                        url(r'^time/plus/(\d{1,2})/$', hours_ahead),
#                        )
