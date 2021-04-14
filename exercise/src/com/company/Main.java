package com.company;

import java.time.temporal.ValueRange;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Main {
    public int solution(int[] arr) {
        // write your code in Java SE 8


        int smallest=1;
      Arrays.sort(arr);

      for (int i=0; i< arr.length; i++) {
          if (arr[i] == smallest) {
              smallest++;
          }
      }

        return smallest;
    }


    public int solutionN(int N) {
        // write your code in Java SE 8

        String number=String.valueOf(N);
        char[] digits1 = number.toCharArray();

        StringBuilder sb = new StringBuilder(number);


       List<Integer> outputs= new ArrayList<>();

        for (int i =0; i<digits1.length+1; i++) {
            String output=sb.insert(i, 5).toString();
            System.out.println(output);
            sb = new StringBuilder(number);
            outputs.add(Integer.valueOf(output));
        }



        Arrays.sort(outputs.toArray());

        return outputs.get(outputs.size()-1);
    }




    public static boolean checkRegex(String ip) {
        boolean goodformat=false;
        String regex= "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";
        String IP_REGEXP = regex+"\\."+regex+"\\."+regex+"\\."+regex;
        Pattern p = Pattern.compile(IP_REGEXP);
        Matcher m = p.matcher(ip);
        String tid ="";
        while (m.find()) {
            tid=m.group(0);
            System.out.println("tid============="+tid);
            goodformat=true;
        }
        return goodformat;
    }


    public static void removeDuplicates(){
        String regex =  "\\b(\\w+)(\\s+\\1\\b)+";


        /*

        \b       match a word boundary
        [a-z]+   match a word with one or more characters;
                 the parentheses capture the word as a group
        \b       match a word boundary
        (?:      indicates a non-capturing group (which starts here)
        \s+      match one or more white space characters
        \1       is a back reference to the first (captured) group;
                 so the word is repeated here
        \b       match a word boundary
        )+       indicates the end of the non-capturing group and
                 allows it to occur one or more times
         */
        Pattern p = Pattern.compile(regex,  Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();

    }


    public static boolean validateUsername (String username) {
        boolean valid=false;
        String regex="^[A-Za-z0-9_]{8,30}$";

        Pattern pattern =Pattern.compile(regex);

        Matcher m = pattern.matcher(username);
        while (m.find()) {
            valid=true;
        }
        return valid;

    }


    public static List<List<Integer>> getSuites ( int [] numbers) {
        List<Integer> suite= new ArrayList<>();
        List<List<Integer>> suites = new ArrayList<>();

        //O(n3)

     /*   for (int i : numbers) {
            suite.add(Integer.valueOf(i));
        }
        Set<Integer> numSet = new HashSet<Integer>(suite);


      //  Arrays.stream(numbers).map(i -> Integer.valueOf(i)).
       //int n = numbers.length;


      List<Integer> test=  numSet.stream().collect(Collectors.toList());
        System.out.println(test.toString());
       int n =test.size();

        for (int i =0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if ((test.get(i) + test.get(j) + test.get(k))== 0) {
                        //System.out.println(numbers[i] + " "+ numbers[j] + " "+ numbers[k]);
                        //int [] found = {numbers[i], numbers[j],numbers[k]};

                       // suites.add(Arrays.asList(Integer.valueOf(numbers[i]), Integer.valueOf(numbers[j]), Integer.valueOf(numbers[k])));

                        suites.add(Arrays.asList(test.get(i), test.get(j), test.get(k)));
                    }

                }
            }
        }


*/

        Arrays.sort(numbers);
        for (int i =0; i<numbers.length && numbers[i] <0; i++) {
            if (i ==0 || numbers[i]==numbers[i-1]) {
                int lo=i+1,hi=numbers.length-1;
               while(lo<hi) {

                    if (numbers[i] + numbers[lo]+numbers[hi] < 0) lo++;
                    else if (numbers[i] + numbers[lo]+numbers[hi] > 0) --hi;
                    else  suites.add(Arrays.asList(numbers[i], numbers[lo++], numbers[hi--]));
                   while (lo < hi && numbers[lo] == numbers[lo - 1])
                       ++lo;
                }


            }

        }

	return suites;

      /*  Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }

        System.out.println(res.toString());
        return res;
*/

        //must not contain duplicate

    }



    static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }


    public static void setToZeo(int [][] arr) {


        List<Integer> row = new ArrayList<>();
        List<Integer> col= new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                if (arr[i][j]==0)   {
                    //for (int x=i; x<arr[i].length; x++) {arr[i][x]=0;}
                    //for (int y=j; y<arr.length; y++) {arr[y][j]=0;}

                   System.out.println("i "+ i + " j "+ j);
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i=0; i<arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
            if ((row.contains(i)) || col.contains(j)) {
                arr[i][j]=0;
                }
            }

        }

        for (int i=0; i<arr.length; i++) {

            System.out.println(Arrays.toString(arr[i]));
        }


    }



    public static List<List<String>> getAnagram(String [] str) {
        Map<String, List<String>> anagram = new HashMap<>();
        for (String s:str) {
            char [] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!anagram.containsKey(key)) anagram.put(key,new ArrayList<>());
             anagram.get(key).add(s);
        }
        System.out.println(anagram.toString());
        return new ArrayList(anagram.values());

    }


    public static int getLongestSubstring (String s) {
        int n=s.length();
        int ans=0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++){
                if (allUnique(s,i,j)) ans=Math.max(ans,j-i);
            }
        }


        return ans;
    }

    public static boolean allUnique(String s ,int start, int end){
        Set unique = new HashSet();
        for (int i=start; i<end; i++){
            char cha = s.charAt(i);
            if (unique.contains(cha)) return false;
            unique.add(cha);

        }

        return true;
    }

    public static boolean canAttend(int [][] hours) {

        boolean can=false;

        if (hours.length==0 || hours.length==1) return true;

        for (int i=0; i<hours.length-1;i++){
              for (int j=i+1; j<hours.length; j++) {
             /*    System.out.print("i " + i + " j "+ j +  ": " + hours[i][j] + " ");
                //compare with the previous row
                 if (i==1 && ((hours[i-1][j] < hours[i][j]) && (hours[i][j]) < hours [i-1][j+1])) return false;
                 //compare with the next row
                 if ((hours[i+1][j] < hours[i][j]) && (hours[i][j]) < hours [i+1][j+1]) return false;
                */


                if(compareInterval(hours[i], hours[j])) return false;

              }
        }

        return true;
    }

    public static boolean compareInterval(int [] a,int [] b){
        //int [] a = {7,10};
        //int [] b = {2,4};

        System.out.println("a==="+ Arrays.toString(a));
        System.out.println("b===="+Arrays.toString(b));
//        if (b[0] > a [0] && b[0] < a[1]) return false;
//        else if (b[1] > a [0] && b[1] < a[1]) return false;
//else
//        return true;


        return (b[0] >= a [0] && b[0] <= a[1]) ||
                (b[1] >= a [0] && b[1] <= a[1]);
    }


    public static void bubleSort(int [] arr) {
        int temp=0;
        int n=arr.length;
       for(int i=0; i<n-1; i++) {
           for (int j=0; j<n-i-1; j++) {
               if (arr[j] > arr[j+1]) {
                   temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }

           }
       }


        System.out.println(Arrays.toString(arr));

//        int n = arr.length;
//        int temp = 0;
//        for(int i=0; i < n; i++){
//            for(int j=1; j < (n-i); j++){
//                if(arr[j-1] > arr[j]){
//                    //swap elements
//                    temp = arr[j-1];
//                    arr[j-1] = arr[j];
//                    arr[j] = temp;
//                }
//
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));

    }



    public static int maxPower(String s) {
        int count=0;
        int max=0;
        char [] arr=s.toCharArray();
        char next=' ';

        for(int i=0; i<s.length(); i++){

            if (s.charAt(i) == next){
                count++;
            }else {
                count=1;
                next=s.charAt(i);
            }

            max=Math.max(max,count);
        }



//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == previous) {
//                // if same as previous one, increase the count
//                count++;
//            } else {
//                // else, reset the count
//                count = 1;
//                previous = c;
//            }
//            max = Math.max(max, count);
//        }


        return max;

    }


    public static List<String> missingWords (String s1, String s2){
        List<String> missingWords = new ArrayList<>();

        String [] s1s=s1.split(" ");
        String [] s2s=s2.split(" ");

        List<String> s1list=Arrays.asList(s1s);
        List<String> s2list=Arrays.asList(s2s);
        //System.out.println(s1list.toString());
        for (int i=0; i<s1list.size();i++) {
          if (!s2list.contains(s1list.get(i))) {
              missingWords.add(s1list.get(i));
          }
        }

        System.out.println(missingWords.toString());
        return missingWords;
    }


    public static int computeSumLessThan (int [] nums, int k) {
        int sum=0;
        int max=0;
        System.out.println("j lenght "+ String.valueOf(nums.length-2));
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length-2; j++){
                System.out.println(i+ " " + nums[i]);
                System.out.println(j+" j" +nums[j]);
                sum=nums[i]+nums[j];
                System.out.println("sum" + sum);
                if (sum < k && max < sum ) {
                    max=sum;
                    System.out.println("max "+ max);

                }

                }

            }
        if (max==0) max=-1;
        System.out.println("max===="+ max);
        return max;
    }

    public static int swapOnceForLargest(int val) {
        String value=String.valueOf(val);
        char[] valarr=value.toCharArray();

        System.out.println( Arrays.toString(valarr));
        int [] arr = new int [value.length()];
        for (int i=0;i<valarr.length; i++) {
            arr[i] = Character.getNumericValue(valarr[i]);

        }
        System.out.println( Arrays.toString(arr));


        List<Integer> largestval= new ArrayList<>();
        for (int k=0; k<arr.length; k++) {
            largestval.add(Integer.valueOf(arr[k]));
        }
        int largest=0;
        for (int y=0; y<largestval.size(); y++) {
            if (largestval.get(y) > largestval.get(largest)) largest=y;
        }


        int max=largestval.get(largest);
        largestval.remove(largest);
        largestval.add(0,max);

        String toconvert=(largestval.stream().map(i -> i.toString()).collect(Collectors.joining("")));
        int a = Integer.valueOf(toconvert);
        return a;
    }


    public static int longestMountain(int[] arr) {
        int [] mountain = new int [arr.length];
        int longest=0;
        if (arr.length < 3) return 0;

        for (int i =0; i<arr.length-2; i++) {
            for (int j=i+1; j<arr.length-1; j++) {
                if ((i==0) && (arr[i] > arr [j])) {
                    System.out.println("i ==0 "+ arr [i]);
                        break;
                }else if (arr[i] < arr [j]) {
                    System.out.println(j);
                    mountain[i] = arr [i];
                    System.out.println(Arrays.toString(mountain));

                    //System.out.println( i + "  "+ j);
                }else if (arr[i] > arr [j]){

                    mountain[i] = arr [i];
                    System.out.println(Arrays.toString(mountain));
                }
            }
        }


        System.out.println(Arrays.toString(mountain));
        return mountain.length;
    }

    public static void main(String[] args) {
	// write your code here
   /*     System.out.println("hello");

        int [] test =  {1, 3, 6, 4, 1, 2};
        int [] test2 =  {1, 2, 3};
        int [] test3 =  {-1, -3};
        System.out.println(new Main().solution(test3));


        int one=268;
        int two=670;
        int three=0;
        int four=-999;
        System.out.println(new Main().solutionN(one));


        String ip="000.12.12.034";
        String notip="hello.123.456.IP";
        System.out.println(checkRegex(notip));

        removeDuplicates();
        System.out.println(validateUsername("_Samantha21"));

        int [] nums = {-1,0,1,2,-1,-4};
        getSuites(nums);

        int[][] arr ={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println(Arrays.toString(arr[0]));
        setToZeo(arr);

        String [] str = {"eat","tea","tan","ate","nat","bat"};
        getAnagram(str);

        String str= "abcabcbb";
        getLongestSubstring(str);

        int max=Integer.MAX_VALUE;
        System.out.println(max);

        int [][] time ={{0,30},{5,10},{15,20}};
        int [][] time2 ={{7,10},{2,4}};
        int [][] time3 ={{0,30},{60,240},{90,120}};
        int [][] time4 ={{9,10},{4,9},{4,17}};

        int [][] time5 ={{12,13},{6,11},{2,19}};
        //System.out.println(Arrays.deepToString(time));
        System.out.println(canAttend(time5));

        int [] nums = {-1,0,1,2,-2,-4};
        bubleSort(nums);

        String power="leetcooooooooode";
        System.out.println(maxPower(power));

        String str1="I am using HackerRank to improve programming";
        String str2="am HackerRank to improve";
        missingWords(str1,str2);


        int [] arr = {34,23,1,24,75,33,54,8};
        int [] arr2= {10,20,30};
        //computeSumLessThan(arr,60);
        computeSumLessThan(arr2,15);



        int simple=2736;
        int tricky=98368;
        swapOnceForLargest(tricky);

         */

        int [] arr ={2,1,4,7,3,2,5};
        int [] noutput ={2,2,2};
        longestMountain(arr);



    }


    public static int computeNodeValue(ListNode head) {
        int num=head.value;
        while(head.next!=null){
            num=num*2+head.next.value;
            head=head.next;
        }
        return num;
    }

    public  static class ListNode {
        int value;
        ListNode next;

        //constructor
        ListNode() {}
        ListNode (int val) { this.value=val;}
        ListNode (int val, ListNode next) {
            this.value=val;
            this.next=next;
        }
    }
}



