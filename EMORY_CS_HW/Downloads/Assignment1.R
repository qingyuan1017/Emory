lambda <- 2
numsim <- 100
mean5 <- rep(0,numsim)
mean25 <- mean5; mean100 <-mean5
for (i in 1:numsim){
  mean5[i]<-mean(rexp(5,lambda))
  mean25[i]<-mean(rexp(25,lambda))
  mean100[i]<-mean(rexp(100,lambda))
}
boxplot(mean5, mean25, mean100, names=c("n=5","n=25","n=100"))
title("Distribution of means of Exponetials")
