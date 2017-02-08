x = linspace(-2,4,100); 
f = @(x) x.^2-2*x;
figure(1)
plot(x,f(x),'b','LineWidth',2);
axis([-2 4 -3 4]);
hold on;
x1 = linspace(0,3,100);
g = @(x1) x1; 
plot(x1,g(x1),'b','LineWidth',2);
hold on;
x3 = linspace(-3,4,100); 
h = @(x3) x3-9/4;
plot(x3,h(x3),'b','LineWidth',2)
hold on;
plot(x3,j(x3),'b','LineWidth',2)