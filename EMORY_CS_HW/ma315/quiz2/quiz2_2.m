syms t
t = linspace(-50,50,500);
x = t.*sin(t);    
y = t.*cos(t);     
figure(1)
plot (x,y);