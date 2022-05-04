
pckage com.lostak.crypto;

import java.util.Scanner;

public class ClaimTime {
		private double initialAmount;		// starting balance
			private int t;						// t = days/period
				private int N;						// N = max number of claims/period
					private double r;					// r = rate/period
						private double amounts[][];			// amounts[# of claims][amount]
							private double fee;					// claim fee
								private boolean staked;				// doubles claim fee
									
									public ClaimTime() {
												this(48.314846, 365*5, .1091, .005075, true);
													}
										
										public ClaimTime(double init, int period, double rate, double fee, boolean staked) {
													initialAmount = init;
															t = period;
																	N = t;
																			r = (rate/365)*t;
																					this.fee = fee;
																							this.staked = staked;
																									
																									N = getBestSize();
																											
																											amounts = new double[N][N];
																													
																													fillAmounts();
																														}
											
											public void fillAmounts() {
														amounts[0][0] = initialAmount;
																
																//Fill in amounts for each number of claims per period
																//		for(int n = 1; n < N; n++) {
																//					amounts[n][0] = initialAmount;
																//								
																//											//Tdouble)n + " days for " + t + " days:" 
																//														+ "\n\n\tValue each claim:");
																//																	
																//																				for(int i = 0; i < n; i++) {
																//																								if(i % 7 == 0) {
																//																													System.out.print("\n\t\t   ");
																//																																	}
																//																																					System.out.print((int)amounts[n][i]+ ", ");
																//																																								}
																//																																											
																//																																														System.out.println((int)amounts[n][n]);
																//																																																	System.out.println("\n\tFinal amount:\n\t\t" + amounts[n][n]);
																//																																																				System.out.println("--------------------------------------------\n");
																//																																																						}
																//																																																							}
																//																																																								
																//																																																									public int getBestRate() {
																//																																																											int maxN = 0, maxI = 0;
																//																																																													for(int n = 1; n < N; n++) {
																//																																																																if(amounts[n][n] > amounts[maxN][maxI]) {
																//																																																																				maxN = n;
																//																																																																								maxI = n;
																//																																																																											}
																//																																																																													}
																//																																																																															
																//																																																																																	System.out.println("Initial amount:\t"+initialAmount);
																//																																																																																			System.out.println("Final amount:\t"+amounts[maxN][maxI]);
																//																																																																																					
																//																																																																																							System.out.println("Best rate:\t"+maxN+" times per "+t+" days or every "+t/maxN+" days");
																//																																																																																									
																//																																																																																											System.out.println("Fees:\t\t"+(float)maxN*fee);		
																//																																																																																													System.out.println("Earned:\t\t"+(amounts[maxN][maxI]-initialAmount)+" in "+t+" days");
																//																																																																																															System.out.println("\t\t"+(amounts[maxN][maxI]-amounts[1][1])+" more than compounding once in "+t+" days");
																//																																																																																																	
																//																																																																																																			return maxN;
																//																																																																																																				}
																//																																																																																																					
																//																																																																																																						public static void main(String[] args) {
																//																																																																																																								Scanner scan = new Scanner(System.in);
																//																																																																																																										//double init = 317.15483, yearlyRate = .0465, fee = .001;
																//																																																																																																												double init = 692.97979, yearlyRate = .0465, fee = .001;
																//																																																																																																														int period = 365*5;
																//																																																																																																																int stake;
																//																																																																																																																		boolean staked = false;
																//																																																																																																																				int contResp = 1;
																//																																																																																																																						
																//																																																																																																																								ClaimTime token;
																//																																																																																																																										
																//																																																																																																																												System.out.println("\n***** Optimal claim time calculator *****\n");
																//																																																																																																																														System.out.println("The optimal constant length period for claiming\n"
																//																																																																																																																																		+ "will be calculated by increasing the period\n"
																//																																																																																																																																						+ "until the final amount begins to decrease.\n"
																//																																																																																																																																										+ "The highest final amount corresponds to the optimal period length\n");
																//																																																																																																																																												
																//																																																																																																																																														try {
																//																																																																																																																																																	while(contResp == 1) {
																//																																																																																																																																																					System.out.println("Enter the investment and chain info	stake = 0;
																//																																																																																																																																																										continue;
																//																																																																																																																																																														}	
																//																																																																																																																																																																	}
																//																																																																																																																																																																			}
																//																																																																																																																																																																					catch(Exception e) {
																//																																																																																																																																																																								e.printStackTrace();	
																//																																																																																																																																																																											scan.close();
																//																																																																																																																																																																														return;
																//																																																																																																																																																																																}finally {
																//																																																																																																																																																																																			scan.close();
																//																																																																																																																																																																																					}
																//																																																																																																																																																																																						}
																//																																																																																																																																																																																									
																//																																																																																																																																																																																										
																//																																																																																																																																																																																										}
																//																																																																																																																																																																																										he next amount is the current amount times 1 + rate(claims per period)
																//																																																																																																																																																																																													for(int i = 0; i < n; i++) {
																//																																																																																																																																																																																																	amounts[n][i+1] = amounts[n][i]*(1+r/n) - fee;
																//																																																																																																																																																																																																					
																//																																																																																																																																																																																																									//two fees for if fee on staking rewards
																//																																																																																																																																																																																																													if(staked) {
																//																																																																																																																																																																																																																		amounts[n][i+1] -= fee;
																//																																																																																																																																																																																																																						}
																//																																																																																																																																																																																																																									}
																//																																																																																																																																																																																																																												
																//																																																																																																																																																																																																																															//Fill in amounts with 0 for rest of array for number of claims
																//																																																																																																																																																																																																																																		for(int i = n+1; i < N; i++) {
																//																																																																																																																																																																																																																																						amounts[n][i] = 0;
																//																																																																																																																																																																																																																																									}
																//																																																																																																																																																																																																																																											}
																//																																																																																																																																																																																																																																												}
																//																																																																																																																																																																																																																																													
																//																																																																																																																																																																																																																																														public int getBestSize() {
																//																																																																																																																																																																																																																																																double lastMax = initialAmount;
																//																																																																																																																																																																																																																																																		double cur = initialAmount;
																//																																																																																																																																																																																																																																																				double last = initialAmount;
																//																																																																																																																																																																																																																																																						//Find best number of claims in order to reduce the size of amounts[][]
																//																																																																																																																																																																																																																																																								for(int n = 1; n < N; n++) {
																//																																																																																																																																																																																																																																																											for(int i = 0; i < n; i++) {
																//																																																																																																																																																																																																																																																															cur = last * (1+r/n) - fee;
																//																																																																																																																																																																																																																																																																			last = cur;
																//																																																																																																																																																																																																																																																																						}
																//																																																																																																																																																																																																																																																																									if(cur > lastMax) {
																//																																																																																																																																																																																																																																																																													lastMax = cur;
																//																																																																																																																																																																																																																																																																																}
																//																																																																																																																																																																																																																																																																																			else {
																//																																																																																																																																																																																																																																																																																							return n;
																//																																																																																																																																																																																																																																																																																										}
																//																																																																																																																																																																																																																																																																																													last = initialAmount;
																//																																																																																																																																																																																																																																																																																															}
																//																																																																																																																																																																																																																																																																																																	return N;
																//																																																																																																																																																																																																																																																																																																		}
																//																																																																																																																																																																																																																																																																																																			
																//																																																																																																																																																																																																																																																																																																				public void print() {
																//																																																																																																																																																																																																																																																																																																						
																//																																																																																																																																																																																																																																																																																																								
																//																																																																																																																																																																																																																																																																																																										for(int n = 1; n < N; n++) {
																//																																																																																																																																																																																																																																																																																																													
																//																																																																																																																																																																																																																																																																																																																System.out.print("Every "+ t/(rmation\n");
																//																																																																																																																																																																																																																																																																																																																						
																//																																																																																																																																																																																																																																																																																																																										System.out.println("Initial Amount: ");
																//																																																																																																																																																																																																																																																																																																																														init = scan.nextDouble();
																//																																																																																																																																																																																																																																																																																																																																				
																//																																																																																																																																																																																																																																																																																																																																								System.out.println("Period Length:");
																//																																																																																																																																																																																																																																																																																																																																												period = scan.nextInt();
																//																																																																																																																																																																																																																																																																																																																																																		
																//																																																																																																																																																																																																																																																																																																																																																						System.out.println("Yearly Rate(APY): ");
																//																																																																																																																																																																																																																																																																																																																																																										yearlyRate = scan.nextDouble();
																//																																																																																																																																																																																																																																																																																																																																																																
																//																																																																																																																																																																																																																																																																																																																																																																				System.out.println("Fee:");
																//																																																																																																																																																																																																																																																																																																																																																																								fee = scan.nextDouble();
																//																																																																																																																																																																																																																																																																																																																																																																														
																//																																																																																																																																																																																																																																																																																																																																																																																		System.out.println("Enter 1 if it is staked\nEnter 0 if it is not staked");
																//																																																																																																																																																																																																																																																																																																																																																																																						stake = scan.nextInt();
																//																																																																																																																																																																																																																																																																																																																																																																																												
																//																																																																																																																																																																																																																																																																																																																																																																																																if(stake == 1) {
																//																																																																																																																																																																																																																																																																																																																																																																																																					staked = true;
																//																																																																																																																																																																																																																																																																																																																																																																																																									}
																//																																																																																																																																																																																																																																																																																																																																																																																																													else {
																//																																																																																																																																																																																																																																																																																																																																																																																																																		staked = false;
																//																																																																																																																																																																																																																																																																																																																																																																																																																						}
																//																																																																																																																																																																																																																																																																																																																																																																																																																												
																//																																																																																																																																																																																																																																																																																																																																																																																																																																token = new ClaimTime(init, period, yearlyRate, fee, staked);
																//																																																																																																																																																																																																																																																																																																																																																																																																																																				token.print();
																//																																																																																																																																																																																																																																																																																																																																																																																																																																								token.getBestRate();
																//																																																																																																																																																																																																																																																																																																																																																																																																																																														
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																		System.out.println("\nEnter 1 to another token\nEnter 0 to exit");
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																						contResp = scan.nextInt();
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																												
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																																if(contResp == 1) {
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																																					System.out.println("\n\t-----New Parameters-----\n");
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																																										init = 0;
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																																															period = 0;
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																																																				yearlyRate = 0;
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									fee = 0;
																//																																																																																																																																																																																																																																																																																																																																																																																																																																																																																													ackage com.lostak.crypto;

import java.util.Scanner;

public class ClaimTime {
	private double initialAmount;		// starting balance
	private int t;						// t = days/period
	private int N;						// N = max number of claims/period
	private double r;					// r = rate/period
	private double amounts[][];			// amounts[# of claims][amount]
	private double fee;					// claim fee
	private boolean staked;				// doubles claim fee
	
	public ClaimTime() {
		this(48.314846, 365*5, .1091, .005075, true);
	}
	
	public ClaimTime(double init, int period, double rate, double fee, boolean staked) {
		initialAmount = init;
		t = period;
		N = t;
		r = (rate/365)*t;
		this.fee = fee;
		this.staked = staked;
		
		N = getBestSize();
		
		amounts = new double[N][N];
		
		fillAmounts();
	}
	
	public void fillAmounts() {
		amounts[0][0] = initialAmount;
		
		//Fill in amounts for each number of claims per period
		for(int n = 1; n < N; n++) {
			amounts[n][0] = initialAmount;
			
			//The next amount is the current amount times 1 + rate(claims per period)
			for(int i = 0; i < n; i++) {
				amounts[n][i+1] = amounts[n][i]*(1+r/n) - fee;
				
				//two fees for if fee on staking rewards
				if(staked) {
					amounts[n][i+1] -= fee;
				}
			}
			
			//Fill in amounts with 0 for rest of array for number of claims
			for(int i = n+1; i < N; i++) {
				amounts[n][i] = 0;
			}
		}
	}
	
	public int getBestSize() {
		double lastMax = initialAmount;
		double cur = initialAmount;
		double last = initialAmount;
		//Find best number of claims in order to reduce the size of amounts[][]
		for(int n = 1; n < N; n++) {
			for(int i = 0; i < n; i++) {
				cur = last * (1+r/n) - fee;
				last = cur;
			}
			if(cur > lastMax) {
				lastMax = cur;
			}
			else {
				return n;
			}
			last = initialAmount;
		}
		return N;
	}
	
	public void print() {
		
		
		for(int n = 1; n < N; n++) {
			
			System.out.print("Every "+ t/(double)n + " days for " + t + " days:" 
			+ "\n\n\tValue each claim:");
			
			for(int i = 0; i < n; i++) {
				if(i % 7 == 0) {
					System.out.print("\n\t\t   ");
				}
				System.out.print((int)amounts[n][i]+ ", ");
			}
			
			System.out.println((int)amounts[n][n]);
			System.out.println("\n\tFinal amount:\n\t\t" + amounts[n][n]);
			System.out.println("--------------------------------------------\n");
		}
	}
	
	public int getBestRate() {
		int maxN = 0, maxI = 0;
		for(int n = 1; n < N; n++) {
			if(amounts[n][n] > amounts[maxN][maxI]) {
				maxN = n;
				maxI = n;
			}
		}
		
		System.out.println("Initial amount:\t"+initialAmount);
		System.out.println("Final amount:\t"+amounts[maxN][maxI]);
		
		System.out.println("Best rate:\t"+maxN+" times per "+t+" days or every "+t/maxN+" days");
		
		System.out.println("Fees:\t\t"+(float)maxN*fee);		
		System.out.println("Earned:\t\t"+(amounts[maxN][maxI]-initialAmount)+" in "+t+" days");
		System.out.println("\t\t"+(amounts[maxN][maxI]-amounts[1][1])+" more than compounding once in "+t+" days");
		
		return maxN;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//double init = 317.15483, yearlyRate = .0465, fee = .001;
		double init = 692.97979, yearlyRate = .0465, fee = .001;
		int period = 365*5;
		int stake;
		boolean staked = false;
		int contResp = 1;
		
		ClaimTime token;
		
		System.out.println("\n***** Optimal claim time calculator *****\n");
		System.out.println("The optimal constant length period for claiming\n"
				+ "will be calculated by increasing the period\n"
				+ "until the final amount begins to decrease.\n"
				+ "The highest final amount corresponds to the optimal period length\n");
		
		try {
			while(contResp == 1) {
				System.out.println("Enter the investment and chain information\n");
						
				System.out.println("Initial Amount: ");
				init = scan.nextDouble();
						
				System.out.println("Period Length:");
				period = scan.nextInt();
						
				System.out.println("Yearly Rate(APY): ");
				yearlyRate = scan.nextDouble();
						
				System.out.println("Fee:");
				fee = scan.nextDouble();
						
				System.out.println("Enter 1 if it is staked\nEnter 0 if it is not staked");
				stake = scan.nextInt();
						
				if(stake == 1) {
					staked = true;
				}
				else {
					staked = false;
				}
						
				token = new ClaimTime(init, period, yearlyRate, fee, staked);
				token.print();
				token.getBestRate();
						
				System.out.println("\nEnter 1 to another token\nEnter 0 to exit");
				contResp = scan.nextInt();
						
				if(contResp == 1) {
					System.out.println("\n\t-----New Parameters-----\n");
					init = 0;
					period = 0;
					yearlyRate = 0;
					fee = 0;
					stake = 0;
					continue;
				}	
			}
		}
		catch(Exception e) {
			e.printStackTrace();	
			scan.close();
			return;
		}finally {
			scan.close();
		}
	}
			
	
}
