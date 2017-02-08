x = linspace(-5,5,100); 
f = @(x) -x.*(x-2).*(x+2).*(x+4).*(x-4);
figure(1)
plot(x,f(x),'b','LineWidth',2);
