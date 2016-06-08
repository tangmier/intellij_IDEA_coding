from django.shortcuts import render_to_response, HttpResponseRedirect
from django.core.mail import send_mail
from contact.forms import ContactForm


# Create your views here.
# def search_form(request):
#     return render_to_response('books/search_form.html')


def contact(request):
    if request.method == 'POST':
        form = ContactForm(request.POST)
        if form.is_valid():
            cd = form.cleaned_data
            send_mail(
                cd['subject'],
                cd['message'],
                cd.get('email', '1374778773@qq.com'),
                ['1003715945@qq.com'],
            )
            return HttpResponseRedirect('/contact/thanks/')
    else:
        form = ContactForm(initial={'subject': 'I love your site!'})
    return render_to_response('contact/contact_form.html', {'form': form})


