x = linspace(-2*pi,2*pi,100);



f = @(x) sin(3*pi*x);
figure(2)
plot(x,f(x),'b','LineWidth',2)