using System;
using System.Collections;
using System.Collections.Generic;

namespace ConsoleApplication
{
    public class Program
    {
        public static void Main(string[] args)
        {
            /*
                two pointers, one at head, one at end.
                keep moving end pointer to head until not 0. then move head pointer
                and keep swapping with end pointer
            */

        }

        public static void ShiftZeros(int[] numbers) {

            int head=0;
            int tail = numbers.Length - 1;

            while (tail > 0 && numbers[tail] ==0 )
                tail--;
            
            while (head < tail) {
                if (numbers[head] == 0)
                {
                    int temp = numbers[tail];
                    numbers[tail] = numbers[head];
                    numbers[head] = temp;
                    tail--;
                    
                }
                head++;
            }
        }

        public List<int> BigMerge(int[][] listOfSorted) {

            return null;
        }
    }
}
