/*******************************************************************************
* Copyright (c) 2008, 2018, Washington University in St. Louis.
* All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
*
* 1. Redistributions of source code must retain the above copyright notice,
*    this list of conditions and the following disclaimer.
*
* 2. Redistributions in binary form must reproduce the above copyright notice,
*    this list of conditions and the following disclaimer in the documentation
*    and/or other materials provided with the distribution.
*
* 3. Products derived from the software may not be called "Looking Glass", nor
*    may "Looking Glass" appear in their name, without prior written permission
*    of Washington University in St. Louis.
*
* 4. All advertising materials mentioning features or use of this software must
*    display the following acknowledgement: "This product includes software
*    developed by Washington University in St. Louis"
*
* 5. The gallery of art assets and animations provided with this software is
*    contributed by Electronic Arts Inc. and may be used for personal,
*    non-commercial, and academic use only. Redistributions of any program
*    source code that utilizes The Sims 2 Assets must also retain the copyright
*    notice, list of conditions and the disclaimer contained in
*    The Alice 3.0 Art Gallery License.
*
* DISCLAIMER:
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.  ANY AND ALL
* EXPRESS, STATUTORY OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
* IMPLIED WARRANTIES OF MERCHANTABILITY,  FITNESS FOR A PARTICULAR PURPOSE,
* TITLE, AND NON-INFRINGEMENT ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHORS,
* COPYRIGHT OWNERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
* INCIDENTAL, SPECIAL, EXEMPLARY, PUNITIVE OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING FROM OR OTHERWISE RELATING TO
* THE USE OF OR OTHER DEALINGS WITH THE SOFTWARE, EVEN IF ADVISED OF THE
* POSSIBILITY OF SUCH DAMAGE.
*******************************************************************************/
package models;

import main.PathwayPuzzle;
import main.PathwayUser;
import java.util.Collections;
import java.util.Arrays;

/**
* @author Wint Hnin
*/
public class TbCe{
	PathwayPuzzle puzzle;
 	PathwayUser user;

	public float getProb( PathwayPuzzle puzzle, PathwayUser user ) {
		this.puzzle = puzzle;
		this.user = user;

		int class_prediction = 0;
		class_prediction += TR0();
		class_prediction += TR1();
		class_prediction += TR2();
		class_prediction += TR3();
		class_prediction += TR4();
		class_prediction += TR5();
		class_prediction += TR6();
		class_prediction += TR7();
		class_prediction += TR8();
		class_prediction += TR9();

		return (float) (class_prediction/10.0);
	}

	private int findMaxIndex( int[] array ) { 
		int max = array[ 0 ];
		int maxIndex = 0;
		for( int i = 1; i < array.length; i++ ) {
			if( array[ i ] > max ) {
				max = array[ i ];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private int TR0() {
		int[] values;
		if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
			if ( user.lastThree_countsOfPlayPuzConsecutivelyAvg <= 1.5) {
				values = new int[] { 0,  5,  13,  2,  4,  15,  3,  0,  0,  2 };
			} else {
				values = new int[] { 5,  5,  9,  0,  4,  5,  0,  0,  0,  14 };
			}
		} else {
			if ( user.notStr_numRepeatedFirstWrongStmtAvg <= 0.8333) {
				if ( user.notStr_numStepsSeparatedNestsAvg <= 0.5) {
					if ( user.lastThreeC <= -1.8333) {
						if ( user.lastThree_structContentAvg <= 3.8333) {
							if ( user.allT <= -1.5) {
								if ( puzzle.getNumStmtsAfterLock() <= 5.5) {
									values = new int[] { 2,  4,  14,  9,  0,  5,  0,  0,  0,  2 };
								} else {
									values = new int[] { 3,  5,  4,  10,  0,  0,  0,  0,  0,  5 };
								}
							} else {
								if ( user.str_noRefPlayedBoolean <= 0.2683) {
									values = new int[] { 1,  4,  6,  6,  5,  7,  7,  5,  0,  2 };
								} else {
									values = new int[] { 17,  3,  6,  3,  1,  4,  1,  3,  1,  16 };
								}
							}
						} else {
							values = new int[] { 12,  0,  2,  4,  0,  3,  0,  5,  0,  6 };
						}
					} else {
						if ( user.notStr_numAttemptsAvg <= 5.1667) {
							if ( user.str_numConstructsAfterLockAvg <= 5.5) {
								if ( user.notStr_numConstructsAfterLockAvg <= 4.1667) {
									values = new int[] { 3,  3,  0,  6,  2,  5,  6,  0,  0,  7 };
								} else {
									values = new int[] { 1,  0,  0,  4,  3,  15,  2,  6,  1,  4 };
								}
							} else {
								values = new int[] { 0,  1,  3,  6,  20,  5,  3,  1,  0,  0 };
							}
						} else {
							values = new int[] { 0,  1,  7,  5,  6,  1,  0,  3,  0,  13 };
						}
					}
				} else {
					if ( user.allC <= -1.5) {
						if ( user.last_changeInScoreAvg <= 0.4231) {
							values = new int[] { 10,  1,  5,  5,  7,  1,  2,  0,  0,  7 };
						} else {
							values = new int[] { 10,  21,  10,  14,  1,  0,  2,  0,  0,  2 };
						}
					} else {
						if ( user.str_CbTbCeeCntAvg <= 0.1667) {
							if ( user.str_structContentAvg <= 3.4167) {
								values = new int[] { 0,  0,  5,  2,  13,  10,  3,  0,  1,  7 };
							} else {
								values = new int[] { 0,  0,  3,  7,  18,  0,  0,  0,  0,  7 };
							}
						} else {
							values = new int[] { 0,  5,  2,  11,  6,  1,  1,  0,  0,  9 };
						}
					}
				}
			} else {
				if ( user.str_changeInScoreAvg <= 0.0853) {
					values = new int[] { 2,  5,  8,  12,  1,  1,  1,  0,  1,  2 };
				} else {
					values = new int[] { 1,  16,  8,  3,  6,  1,  2,  0,  0,  1 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR1() {
		int[] values;
		if ( user.lastThreeT <= 0.8333) {
			if ( user.lastThree_numAttemptsAvg <= 1.8333) {
				values = new int[] { 1,  2,  5,  18,  3,  4,  1,  0,  0,  10 };
			} else {
				if ( user.str_numConstructsAfterLockAvg <= 4.8333) {
					if ( user.last_postRefPlayScoreAvg <= 0.6018) {
						if ( user.notStr_numStepsSeparatedNestsAvg <= 0.8333) {
							if ( user.str_noRefPlayedBoolean <= 0.0208) {
								values = new int[] { 14,  9,  7,  1,  1,  2,  0,  0,  0,  3 };
							} else {
								if ( user.lastThree_numAttemptsConstructErrorsAvg <= 1.8333) {
									if ( user.notStr_CbTbCeeCntAvg <= 0.1667) {
										values = new int[] { 2,  5,  10,  1,  0,  11,  1,  0,  2,  5 };
									} else {
										values = new int[] { 2,  0,  18,  7,  2,  2,  1,  2,  0,  2 };
									}
								} else {
									values = new int[] { 8,  1,  6,  12,  0,  2,  2,  0,  3,  15 };
								}
							}
						} else {
							if ( user.str_numMoveSameStmtConsecutivelyAvg <= 3.8333) {
								if ( user.notStr_noRefPlayedBoolean <= 0.3031) {
									values = new int[] { 3,  2,  9,  4,  1,  2,  1,  0,  0,  4 };
								} else {
									values = new int[] { 1,  11,  22,  2,  3,  2,  0,  0,  0,  0 };
								}
							} else {
								values = new int[] { 4,  21,  7,  6,  3,  0,  0,  2,  0,  3 };
							}
						}
					} else {
						if ( user.lastThree_numRepeatedFirstWrongStmtAvg <= 0.1667) {
							values = new int[] { 0,  3,  2,  8,  5,  9,  2,  2,  0,  3 };
						} else {
							values = new int[] { 9,  5,  10,  8,  1,  0,  3,  2,  0,  5 };
						}
					}
				} else {
					if ( user.lastThree_cogLoadAvg <= -1.8333) {
						values = new int[] { 6,  22,  10,  3,  5,  5,  0,  1,  0,  1 };
					} else {
						if ( user.notStr_noRefPlayedBoolean <= 0.2587) {
							values = new int[] { 1,  1,  2,  3,  21,  2,  1,  1,  3,  6 };
						} else {
							values = new int[] { 4,  4,  13,  7,  3,  2,  5,  0,  0,  12 };
						}
					}
				}
			}
		} else {
			if ( user.str_numResetAvg <= 0.1667) {
				if ( user.lastThreeCbTe <= -0.1667) {
					if ( user.lastThree_postRefPlayScoreAvg <= 0.2302) {
						values = new int[] { 0,  0,  0,  3,  0,  13,  2,  0,  1,  9 };
					} else {
						values = new int[] { 2,  2,  1,  5,  3,  6,  9,  0,  0,  9 };
					}
				} else {
					if ( user.str_TCntAvg <= 0.5833) {
						values = new int[] { 0,  1,  3,  3,  24,  3,  3,  1,  1,  2 };
					} else {
						values = new int[] { 3,  1,  0,  4,  7,  4,  3,  1,  1,  5 };
					}
				}
			} else {
				values = new int[] { 0,  0,  0,  4,  2,  6,  1,  1,  0,  16 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR2() {
		int[] values;
		if ( user.notStr_cogLoadAvg <= -2.1667) {
			if ( user.notStr_numAttemptsConstructErrorsAvg <= 2.8333) {
				if ( user.notStr_numAttemptsOfdoTogetherRearrangementsAvg <= 0.1667) {
					if ( user.str_cogLoadAvg <= 4.8333) {
						if ( user.str_changeInScoreAvg <= 0.2528) {
							values = new int[] { 11,  3,  3,  10,  0,  1,  2,  0,  0,  4 };
						} else {
							if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 3.8333) {
								values = new int[] { 7,  6,  4,  1,  7,  3,  3,  2,  0,  2 };
							} else {
								values = new int[] { 15,  0,  2,  0,  1,  3,  2,  2,  0,  6 };
							}
						}
					} else {
						if ( user.notStr_changeInScoreAvg <= 0.4414) {
							values = new int[] { 2,  5,  7,  10,  2,  2,  0,  0,  0,  1 };
						} else {
							values = new int[] { 1,  9,  0,  3,  2,  2,  0,  0,  2,  12 };
						}
					}
				} else {
					values = new int[] { 7,  20,  6,  2,  1,  2,  0,  0,  0,  4 };
				}
			} else {
				values = new int[] { 19,  3,  5,  0,  1,  1,  0,  0,  0,  1 };
			}
		} else {
			if ( user.str_numConstructsAfterLockAvg <= 2.8333) {
				if ( user.lastThree_cogLoadAvg <= -1.5) {
					values = new int[] { 0,  6,  19,  5,  1,  5,  1,  0,  0,  1 };
				} else {
					if ( user.str_numAttemptsAvg <= 6.8333) {
						values = new int[] { 0,  8,  4,  5,  10,  3,  1,  0,  2,  7 };
					} else {
						values = new int[] { 0,  7,  21,  14,  3,  4,  3,  0,  2,  5 };
					}
				}
			} else {
				if ( user.all_cogLoad <= -0.7178) {
					if ( user.notStr_changeInScoreAvg <= 0.4707) {
						if ( user.notStr_changeInConstructScoreAvg <= -0.1667) {
							values = new int[] { 5,  2,  17,  9,  0,  0,  2,  1,  0,  2 };
						} else {
							values = new int[] { 3,  2,  5,  7,  5,  2,  1,  8,  0,  9 };
						}
					} else {
						values = new int[] { 0,  9,  14,  1,  2,  9,  2,  0,  0,  12 };
					}
				} else {
					if ( user.notStr_CCntAvg <= 6.8333) {
						if ( user.last_numAttemptsOfoneOrZeroInDoTAvg <= 1.5) {
							if ( user.notStr_structContentAvg <= 3.1667) {
								values = new int[] { 0,  1,  11,  2,  11,  23,  6,  2,  0,  10 };
							} else {
								values = new int[] { 0,  3,  3,  5,  18,  3,  8,  0,  0,  11 };
							}
						} else {
							values = new int[] { 0,  1,  0,  19,  5,  8,  2,  0,  3,  7 };
						}
					} else {
						values = new int[] { 0,  1,  2,  3,  22,  3,  1,  2,  0,  8 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR3() {
		int[] values;
		if ( user.allTbCe <= -0.5) {
			if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 32.5) {
				if ( user.notStr_numCorrectedFirstWrongIndexAvg <= 0.8333) {
					if ( user.lastThree_numReducedFirstWrongIndexAvg <= 1.5) {
						values = new int[] { 1,  4,  5,  7,  3,  3,  1,  1,  0,  9 };
					} else {
						values = new int[] { 1,  25,  9,  6,  2,  6,  0,  0,  0,  2 };
					}
				} else {
					values = new int[] { 7,  10,  14,  5,  1,  1,  0,  0,  0,  2 };
				}
			} else {
				if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 15.5) {
					values = new int[] { 2,  8,  1,  1,  1,  0,  2,  0,  0,  14 };
				} else {
					if ( user.notStr_TbCObTeeCntAvg <= 0.5) {
						values = new int[] { 3,  4,  10,  1,  9,  2,  2,  0,  0,  5 };
					} else {
						values = new int[] { 15,  4,  3,  5,  1,  4,  1,  0,  0,  8 };
					}
				}
			}
		} else {
			if ( user.all_cogLoad <= -1.1877) {
				if ( user.lastThreeT <= -0.6667) {
					values = new int[] { 9,  4,  15,  5,  1,  1,  0,  0,  0,  2 };
				} else {
					values = new int[] { 6,  11,  6,  2,  0,  2,  0,  0,  0,  6 };
				}
			} else {
				if ( user.lastThreeCbTe <= 1.1667) {
					if ( user.notStr_numStepsSeparatedNestsAvg <= 1.1667) {
						if ( user.str_numAttemptsConstructErrorsAvg <= 4.8333) {
							if ( user.notStr_numConstructsAfterLockAvg <= 2.5) {
								values = new int[] { 3,  2,  2,  0,  2,  2,  2,  0,  1,  20 };
							} else {
								if ( user.lastThree_changeInScoreAvg <= 0.4705) {
									if ( user.last_changeInScoreAvg <= 0.453) {
										if ( user.last_noRefPlayedBoolean <= 0.4167) {
											values = new int[] { 0,  0,  3,  2,  8,  8,  6,  0,  0,  3 };
										} else {
											values = new int[] { 2,  1,  3,  7,  3,  8,  1,  0,  0,  2 };
										}
									} else {
										values = new int[] { 0,  4,  6,  1,  10,  2,  9,  6,  0,  3 };
									}
								} else {
									if ( puzzle.getCbTeCnt() <= 0.5) {
										values = new int[] { 2,  3,  1,  4,  5,  13,  3,  0,  0,  17 };
									} else {
										values = new int[] { 0,  1,  3,  7,  6,  11,  1,  0,  0,  2 };
									}
								}
							}
						} else {
							if ( user.lastThree_noRefPlayedBoolean <= 0.3373) {
								values = new int[] { 2,  0,  10,  11,  2,  1,  1,  0,  0,  1 };
							} else {
								if ( user.lastThree_CbCeCntAvg <= 0.1667) {
									values = new int[] { 0,  3,  2,  6,  6,  0,  2,  0,  3,  8 };
								} else {
									values = new int[] { 4,  5,  1,  11,  1,  3,  7,  2,  0,  2 };
								}
							}
						}
					} else {
						values = new int[] { 0,  4,  1,  19,  10,  3,  1,  0,  0,  2 };
					}
				} else {
					if ( puzzle.getNumStmtsInLock() <= 1.5) {
						values = new int[] { 1,  0,  0,  3,  18,  1,  1,  1,  2,  3 };
					} else {
						values = new int[] { 1,  0,  4,  2,  5,  8,  1,  2,  1,  2 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR4() {
		int[] values;
		if ( user.lastThreeCbTe <= -3.1667) {
			if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 22.5) {
				values = new int[] { 24,  8,  4,  0,  0,  1,  1,  0,  0,  1 };
			} else {
				values = new int[] { 7,  2,  8,  4,  0,  5,  0,  0,  0,  2 };
			}
		} else {
			if ( user.lastThreeCbCe <= -1.8333) {
				if ( user.allCbCe <= -1.5) {
					if ( user.str_structContentAvg <= 3.8333) {
						if ( puzzle.getUniqueStatementsCount() <= 6.5) {
							values = new int[] { 6,  16,  16,  3,  3,  3,  0,  0,  0,  7 };
						} else {
							values = new int[] { 2,  5,  15,  16,  1,  5,  0,  0,  0,  2 };
						}
					} else {
						values = new int[] { 0,  9,  1,  13,  3,  2,  0,  3,  0,  1 };
					}
				} else {
					values = new int[] { 0,  4,  18,  4,  3,  4,  5,  3,  0,  4 };
				}
			} else {
				if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 30.8333) {
					if ( user.last_changeInScoreAvg <= 0.6962) {
						if ( user.lastThreeTbCe <= -0.8333) {
							values = new int[] { 1,  1,  2,  9,  0,  3,  1,  0,  0,  21 };
						} else {
							if ( user.notStr_numStepsSeparatedNestsAvg <= 0.1667) {
								if ( user.str_numCorrectedFirstWrongIndexAvg <= 0.1667) {
									values = new int[] { 0,  1,  6,  5,  7,  17,  0,  1,  0,  2 };
								} else {
									values = new int[] { 0,  0,  4,  6,  4,  11,  13,  1,  0,  19 };
								}
							} else {
								if ( user.str_structContentAvg <= 3.5) {
									values = new int[] { 2,  4,  5,  4,  18,  6,  0,  0,  1,  4 };
								} else {
									values = new int[] { 0,  0,  2,  5,  12,  1,  0,  0,  0,  17 };
								}
							}
						}
					} else {
						if ( user.notStr_numAttemptsAvg <= 4.8333) {
							values = new int[] { 0,  5,  0,  3,  13,  10,  4,  4,  1,  0 };
						} else {
							values = new int[] { 3,  13,  4,  4,  16,  1,  0,  2,  2,  14 };
						}
					}
				} else {
					if ( user.allCbCe <= -0.5) {
						values = new int[] { 0,  15,  8,  1,  0,  6,  0,  0,  0,  2 };
					} else {
						if ( user.lastThree_CbCeCntAvg <= 0.1667) {
							values = new int[] { 1,  0,  3,  13,  7,  9,  6,  0,  1,  14 };
						} else {
							values = new int[] { 7,  2,  12,  22,  5,  2,  3,  0,  0,  4 };
						}
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR5() {
		int[] values;
		if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 12.5) {
			values = new int[] { 0,  2,  5,  5,  7,  19,  2,  2,  1,  4 };
		} else {
			if ( user.str_cogLoadAvg <= 4.8333) {
				if ( user.str_nestingDepthAvg <= 1.1667) {
					if ( user.lastThree_numAttemptsConstructErrorsAvg <= 1.8333) {
						if ( user.lastThree_numAttemptsAvg <= 3.5) {
							values = new int[] { 4,  5,  2,  6,  1,  6,  0,  1,  0,  7 };
						} else {
							values = new int[] { 4,  9,  16,  0,  1,  2,  2,  0,  0,  5 };
						}
					} else {
						values = new int[] { 20,  3,  10,  2,  2,  3,  0,  0,  0,  0 };
					}
				} else {
					if ( user.lastThree_changeInScoreAvg <= 0.3125) {
						if ( user.str_numMoveSameStmtConsecutivelyAvg <= 2.5833) {
							values = new int[] { 12,  3,  5,  2,  2,  3,  4,  0,  0,  3 };
						} else {
							values = new int[] { 2,  1,  5,  0,  0,  5,  2,  1,  1,  9 };
						}
					} else {
						if ( user.str_noRefPlayedBoolean <= 0.3883) {
							if ( user.lastThree_numAttemptsConstructErrorsAvg <= 3.1667) {
								if ( user.lastThree_noRefPlayedBoolean <= 0.2583) {
									values = new int[] { 0,  1,  0,  4,  21,  3,  3,  3,  0,  2 };
								} else {
									values = new int[] { 1,  4,  3,  7,  12,  2,  6,  0,  0,  5 };
								}
							} else {
								values = new int[] { 14,  1,  10,  2,  6,  9,  1,  0,  0,  1 };
							}
						} else {
							if ( user.str_numMoveSameStmtConsecutivelyAvg <= 3.25) {
								values = new int[] { 0,  3,  2,  3,  9,  5,  1,  2,  0,  15 };
							} else {
								values = new int[] { 5,  4,  0,  19,  7,  4,  3,  2,  2,  4 };
							}
						}
					}
				}
			} else {
				if ( user.last_noRefPlayedBoolean <= 0.3604) {
					if ( user.lastThree_noRefPlayedBoolean <= 0.3133) {
						if ( user.str_CbCeCntAvg <= 0.1667) {
							values = new int[] { 0,  14,  6,  8,  1,  3,  0,  1,  0,  0 };
						} else {
							values = new int[] { 0,  5,  2,  20,  4,  5,  0,  0,  2,  2 };
						}
					} else {
						values = new int[] { 2,  3,  5,  8,  2,  6,  0,  0,  4,  14 };
					}
				} else {
					if ( user.lastThreeT <= 0.8333) {
						if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 30.5) {
							if ( user.str_TCntAvg <= 0.1667) {
								values = new int[] { 3,  8,  11,  3,  2,  2,  0,  0,  0,  10 };
							} else {
								values = new int[] { 6,  1,  5,  6,  2,  2,  0,  0,  0,  11 };
							}
						} else {
							values = new int[] { 2,  7,  24,  4,  2,  1,  0,  0,  0,  3 };
						}
					} else {
						values = new int[] { 0,  2,  2,  4,  12,  8,  2,  0,  0,  11 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR6() {
		int[] values;
		if ( user.str_changeInConstructScoreAvg <= -0.1667) {
			if ( user.lastThree_postRefPlayScoreAvg <= 0.0465) {
				values = new int[] { 4,  7,  5,  11,  1,  9,  2,  0,  0,  3 };
			} else {
				if ( user.lastThree_cogLoadAvg <= -1.8333) {
					values = new int[] { 7,  3,  3,  6,  1,  0,  3,  0,  0,  3 };
				} else {
					if ( user.notStr_CCntAvg <= 5.1667) {
						values = new int[] { 1,  0,  2,  1,  8,  4,  0,  1,  0,  19 };
					} else {
						if ( user.allT <= -0.5) {
							if ( user.lastThree_numPlaySameSetAvg <= 0.5) {
								values = new int[] { 1,  3,  4,  6,  14,  2,  2,  1,  0,  2 };
							} else {
								values = new int[] { 6,  10,  10,  1,  4,  1,  0,  0,  0,  5 };
							}
						} else {
							if ( user.notStr_numRepeatedErrorWithInsertionsAvg <= 0.5) {
								values = new int[] { 0,  0,  1,  4,  3,  4,  9,  2,  0,  7 };
							} else {
								values = new int[] { 1,  0,  2,  5,  16,  5,  3,  2,  0,  4 };
							}
						}
					}
				}
			}
		} else {
			if ( user.str_CCntAvg <= 8.4167) {
				if ( user.str_numPlaySameSetAvg <= 1.1667) {
					if ( user.allT <= -1.5) {
						if ( user.lastThree_cogLoadAvg <= -2.5) {
							values = new int[] { 13,  9,  6,  7,  0,  5,  0,  0,  0,  0 };
						} else {
							if ( user.last_numConstructsAfterLockAvg <= 5.5) {
								values = new int[] { 0,  4,  27,  5,  0,  4,  0,  0,  0,  4 };
							} else {
								if ( user.notStr_postRefPlayScoreAvg <= 0.2646) {
									values = new int[] { 5,  7,  7,  5,  2,  0,  0,  0,  0,  8 };
								} else {
									values = new int[] { 7,  6,  13,  2,  0,  1,  0,  0,  0,  1 };
								}
							}
						}
					} else {
						if ( user.all_cogLoad <= -0.7594) {
							if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 25.8333) {
								values = new int[] { 1,  2,  12,  3,  5,  6,  1,  0,  0,  6 };
							} else {
								values = new int[] { 10,  17,  8,  3,  3,  8,  3,  0,  1,  3 };
							}
						} else {
							if ( user.notStr_numAttemptsAvg <= 5.1667) {
								if ( user.lastThree_postRefPlayScoreAvg <= 0.2768) {
									values = new int[] { 2,  3,  3,  2,  5,  8,  3,  2,  0,  3 };
								} else {
									values = new int[] { 1,  1,  0,  0,  3,  5,  3,  2,  2,  14 };
								}
							} else {
								if ( user.last_changeInScoreAvg <= 0.6754) {
									values = new int[] { 0,  0,  2,  5,  9,  1,  1,  0,  0,  6 };
								} else {
									values = new int[] { 3,  6,  8,  8,  4,  1,  1,  0,  0,  7 };
								}
							}
						}
					}
				} else {
					values = new int[] { 0,  0,  2,  17,  4,  4,  2,  3,  0,  11 };
				}
			} else {
				values = new int[] { 0,  26,  11,  6,  1,  5,  0,  0,  0,  2 };
			}
		}
		return findMaxIndex(values);
	}

	private int TR7() {
		int[] values;
		if ( user.lastThree_cogLoadAvg <= -1.1667) {
			if ( user.notStr_numAttemptsAvg <= 2.1667) {
				values = new int[] { 10,  4,  4,  8,  5,  7,  2,  2,  0,  7 };
			} else {
				if ( user.str_numConstructsAfterLockAvg <= 4.1667) {
					if ( user.notStr_noRefPlayedBoolean <= 0.5836) {
						if ( user.lastThree_cogLoadAvg <= -2.5) {
							values = new int[] { 9,  18,  5,  1,  2,  2,  0,  0,  0,  0 };
						} else {
							values = new int[] { 0,  9,  21,  11,  0,  3,  1,  0,  0,  4 };
						}
					} else {
						values = new int[] { 1,  8,  15,  6,  0,  2,  0,  0,  0,  13 };
					}
				} else {
					values = new int[] { 4,  25,  2,  12,  7,  7,  3,  3,  0,  0 };
				}
			}
		} else {
			if ( user.allCbTe <= -0.5) {
				if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 4.5) {
					if ( user.last_numStepsSeparatedNestsAvg <= 0.5) {
						if ( user.str_postRefPlayScoreAvg <= 0.0824) {
							values = new int[] { 5,  5,  10,  0,  2,  8,  11,  2,  0,  6 };
						} else {
							if ( user.last_numAttemptsConstructErrorsAvg <= 3.5) {
								if ( puzzle.getNumStmtsInLock() <= 1.5) {
									values = new int[] { 0,  4,  3,  4,  3,  4,  0,  1,  0,  25 };
								} else {
									values = new int[] { 1,  5,  7,  3,  7,  1,  3,  1,  0,  9 };
								}
							} else {
								values = new int[] { 5,  5,  1,  7,  2,  4,  1,  0,  0,  8 };
							}
						}
					} else {
						if ( user.notStr_numRepeatedFirstWrongStmtAvg <= 0.1667) {
							values = new int[] { 4,  2,  6,  13,  5,  6,  0,  1,  1,  5 };
						} else {
							values = new int[] { 11,  3,  9,  2,  19,  1,  1,  1,  0,  4 };
						}
					}
				} else {
					values = new int[] { 9,  8,  1,  12,  1,  6,  5,  0,  2,  2 };
				}
			} else {
				if ( user.lastThree_structContentAvg <= 3.5) {
					if ( user.notStr_numAttemptsWithoutOrderingBoxAvg <= 0.1667) {
						values = new int[] { 1,  1,  2,  13,  9,  12,  7,  0,  1,  3 };
					} else {
						values = new int[] { 1,  3,  5,  4,  17,  6,  5,  3,  1,  6 };
					}
				} else {
					values = new int[] { 2,  0,  12,  2,  28,  0,  0,  1,  2,  9 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR8() {
		int[] values;
		if ( user.str_unfamMethodsAvg <= 1.4167) {
			if ( user.notStr_numAttemptsAvg <= 3.8333) {
				if ( user.lastThree_numAttemptsAvg <= 2.8333) {
					values = new int[] { 5,  4,  3,  2,  1,  8,  4,  0,  0,  5 };
				} else {
					values = new int[] { 5,  2,  9,  7,  2,  4,  3,  5,  0,  0 };
				}
			} else {
				if ( user.notStr_cogLoadAvg <= -2.1667) {
					values = new int[] { 12,  30,  7,  0,  0,  3,  0,  0,  0,  1 };
				} else {
					if ( user.notStr_CCntAvg <= 5.5) {
						values = new int[] { 1,  5,  2,  11,  6,  1,  0,  0,  0,  5 };
					} else {
						values = new int[] { 0,  3,  11,  2,  4,  3,  0,  0,  0,  7 };
					}
				}
			}
		} else {
			if ( user.lastThree_numAttemptsOfoneOrZeroInDoTAvg <= 1.1667) {
				if ( user.str_structContentAvg <= 4.5) {
					if ( user.lastThree_numCorrectButNotPlayedAvg <= 1.1667) {
						if ( user.str_CbTbCeeCntAvg <= 0.1667) {
							if ( user.lastThree_numAttemptsAvg <= 4.8333) {
								if ( user.lastThree_structContentAvg <= 2.8333) {
									values = new int[] { 0,  2,  4,  6,  5,  1,  2,  0,  0,  14 };
								} else {
									values = new int[] { 3,  3,  5,  3,  12,  6,  17,  1,  0,  12 };
								}
							} else {
								if ( user.str_numMoveSameStmtConsecutivelyAvg <= 4.5) {
									values = new int[] { 14,  6,  10,  3,  8,  12,  3,  1,  0,  3 };
								} else {
									values = new int[] { 3,  3,  2,  3,  4,  4,  1,  0,  2,  12 };
								}
							}
						} else {
							if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 1.8333) {
								if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 19.1667) {
									values = new int[] { 1,  3,  7,  12,  3,  8,  2,  0,  1,  8 };
								} else {
									values = new int[] { 1,  2,  10,  1,  4,  2,  0,  0,  0,  7 };
								}
							} else {
								values = new int[] { 0,  5,  1,  4,  4,  1,  0,  0,  0,  34 };
							}
						}
					} else {
						values = new int[] { 4,  3,  5,  5,  2,  19,  0,  0,  2,  3 };
					}
				} else {
					values = new int[] { 0,  1,  6,  14,  14,  8,  1,  1,  0,  4 };
				}
			} else {
				if ( user.last_changeInScoreAvg <= 0.7395) {
					if ( user.lastThree_numMoveSameStmtConsecutivelyAvg <= 4.5) {
						values = new int[] { 9,  0,  8,  9,  7,  0,  2,  0,  0,  4 };
					} else {
						values = new int[] { 3,  6,  4,  9,  0,  8,  0,  1,  1,  1 };
					}
				} else {
					values = new int[] { 2,  2,  12,  3,  3,  7,  11,  1,  0,  3 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR9() {
		int[] values;
		if ( user.allCbCe <= 0.5) {
			if ( user.notStr_cogLoadAvg <= -2.5) {
				if ( user.str_cogLoadAvg <= 4.8333) {
					if ( user.lastThreeCbCe <= -1.5) {
						if ( user.all_cogLoad <= -1.2911) {
							values = new int[] { 16,  10,  3,  5,  1,  0,  0,  0,  0,  2 };
						} else {
							values = new int[] { 3,  16,  8,  7,  3,  0,  0,  0,  0,  1 };
						}
					} else {
						values = new int[] { 14,  5,  2,  0,  3,  0,  1,  0,  0,  6 };
					}
				} else {
					values = new int[] { 1,  11,  4,  16,  6,  1,  0,  0,  0,  4 };
				}
			} else {
				if ( user.str_numStepsAvg <= 0.1667) {
					if ( user.str_noRefPlayedBoolean <= 0.4588) {
						if ( user.notStr_TbCObTeeCntAvg <= 0.5) {
							if ( user.lastThreeTbCe <= 0.5) {
								values = new int[] { 0,  6,  30,  17,  2,  2,  5,  0,  0,  1 };
							} else {
								values = new int[] { 8,  3,  13,  7,  3,  10,  2,  0,  1,  5 };
							}
						} else {
							if ( user.notStr_numStepsSeparatedNestsAvg <= 0.8333) {
								values = new int[] { 0,  6,  10,  2,  0,  17,  1,  1,  0,  9 };
							} else {
								values = new int[] { 2,  15,  13,  3,  6,  1,  1,  0,  0,  6 };
							}
						}
					} else {
						if ( user.last_numAttemptsAvg <= 4.5) {
							values = new int[] { 0,  1,  5,  6,  4,  2,  1,  3,  0,  8 };
						} else {
							values = new int[] { 3,  6,  0,  24,  10,  5,  0,  3,  1,  2 };
						}
					}
				} else {
					if ( user.notStr_CbCeCntAvg <= 0.1667) {
						values = new int[] { 1,  1,  9,  1,  7,  4,  3,  0,  1,  5 };
					} else {
						values = new int[] { 0,  5,  15,  1,  2,  3,  4,  2,  0,  0 };
					}
				}
			}
		} else {
			if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 46.1667) {
				if ( user.last_numMoveSameStmtConsecutivelyAvg <= 0.5) {
					values = new int[] { 0,  1,  13,  1,  19,  3,  0,  2,  0,  15 };
				} else {
					if ( user.lastThreeCbCe <= 1.5) {
						values = new int[] { 2,  3,  2,  19,  9,  6,  1,  2,  0,  7 };
					} else {
						values = new int[] { 0,  0,  5,  4,  9,  15,  2,  3,  3,  15 };
					}
				}
			} else {
				values = new int[] { 9,  1,  1,  5,  4,  5,  8,  0,  0,  3 };
			}
		}
		return findMaxIndex(values);
	}

}