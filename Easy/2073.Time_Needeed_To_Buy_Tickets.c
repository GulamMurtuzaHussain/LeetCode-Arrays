int timeRequiredToBuy(int *tickets, int ticketsSize, int k)
{
    int time=0;
    while(tickets[k]>0)
    {
        for(int i=0; i<ticketsSize; i++)
        { 
            if(tickets[k]==0)
            {
                return time;
            }
            if(tickets[i]<=0){
                continue;
            }
            else
            {
                tickets[i]--;
                time++;
            }
        }
    }
    return time;
}
