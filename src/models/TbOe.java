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
public class TbOe{
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
		if ( user.str_unfamMethodsAvg <= 1.8333) {
			if ( user.allCbTe <= -2.5) {
				values = new int[] { 27,  11,  3,  0,  0,  0,  0,  0,  0,  0 };
			} else {
				if ( user.str_CCntAvg <= 2.1667) {
					values = new int[] { 0,  31,  3,  2,  2,  0,  0,  0,  0,  1 };
				} else {
					if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 33.3333) {
						if ( user.str_structContentAvg <= 2.8333) {
							if ( user.lastThree_structContentAvg <= 2.5) {
								values = new int[] { 0,  10,  22,  1,  2,  2,  2,  0,  0,  0 };
							} else {
								values = new int[] { 1,  14,  8,  3,  0,  0,  0,  1,  0,  1 };
							}
						} else {
							values = new int[] { 18,  10,  6,  1,  1,  0,  0,  0,  0,  7 };
						}
					} else {
						values = new int[] { 3,  18,  2,  0,  2,  0,  0,  0,  0,  5 };
					}
				}
			}
		} else {
			if ( user.str_numAttemptsAvg <= 9.8333) {
				if ( user.str_TbCObTeeCntAvg <= 0.5833) {
					if ( user.str_noRefPlayedBoolean <= 0.2426) {
						if ( user.notStr_numAttemptsAvg <= 2.8333) {
							values = new int[] { 2,  4,  0,  3,  5,  0,  1,  0,  0,  17 };
						} else {
							if ( user.str_numCorrectedFirstWrongIndexAvg <= 0.5) {
								values = new int[] { 2,  3,  4,  7,  17,  11,  1,  2,  0,  5 };
							} else {
								values = new int[] { 17,  3,  4,  4,  4,  7,  2,  0,  2,  4 };
							}
						}
					} else {
						if ( user.lastThreeCbCe <= -1.8333) {
							values = new int[] { 0,  4,  17,  0,  0,  0,  1,  0,  0,  7 };
						} else {
							if ( user.str_numMoveSameStmtConsecutivelyAvg <= 2.5) {
								if ( user.str_countsOfPlayConsecutivelyAvg <= 0.037) {
									values = new int[] { 1,  0,  3,  16,  0,  1,  2,  0,  0,  17 };
								} else {
									values = new int[] { 1,  2,  6,  18,  9,  2,  0,  0,  0,  5 };
								}
							} else {
								values = new int[] { 1,  3,  2,  3,  2,  1,  1,  1,  0,  20 };
							}
						}
					}
				} else {
					if ( user.str_numConstructsInLockAvg <= 1.1667) {
						values = new int[] { 8,  10,  10,  5,  7,  4,  1,  0,  0,  3 };
					} else {
						values = new int[] { 3,  7,  14,  1,  0,  1,  0,  0,  0,  4 };
					}
				}
			} else {
				if ( user.str_CCntAvg <= 7.5) {
					if ( user.last_numAttemptsAvg <= 8.5) {
						if ( user.lastThree_CbCeCntAvg <= 0.1667) {
							if ( user.notStr_countsOfPlayPuzConsecutivelyAvg <= 0.5) {
								values = new int[] { 3,  19,  8,  2,  2,  0,  0,  4,  0,  4 };
							} else {
								values = new int[] { 17,  12,  7,  10,  8,  1,  0,  3,  0,  1 };
							}
						} else {
							values = new int[] { 20,  10,  5,  2,  5,  2,  0,  0,  0,  1 };
						}
					} else {
						if ( user.all_cogLoad <= -0.811) {
							values = new int[] { 3,  14,  6,  7,  2,  0,  0,  0,  0,  4 };
						} else {
							values = new int[] { 0,  0,  5,  1,  7,  1,  0,  3,  0,  16 };
						}
					}
				} else {
					values = new int[] { 4,  2,  7,  19,  2,  1,  2,  4,  0,  3 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR1() {
		int[] values;
		if ( user.lastThreeT <= -1.1667) {
			if ( user.str_numAttemptsWithoutOrderingBoxAvg <= 0.1667) {
				if ( user.notStr_countsOfPlayPuzConsecutivelyAvg <= 0.5) {
					if ( user.last_postRefPlayScoreAvg <= 0.1791) {
						values = new int[] { 2,  27,  6,  0,  1,  3,  0,  0,  0,  0 };
					} else {
						values = new int[] { 4,  22,  8,  2,  0,  0,  0,  0,  0,  4 };
					}
				} else {
					if ( user.notStr_numAttemptsAvg <= 6.5) {
						values = new int[] { 17,  21,  4,  8,  1,  0,  2,  2,  0,  0 };
					} else {
						values = new int[] { 6,  21,  1,  1,  2,  0,  1,  0,  0,  0 };
					}
				}
			} else {
				values = new int[] { 15,  10,  21,  0,  2,  1,  0,  0,  0,  6 };
			}
		} else {
			if ( user.allTbOe <= -0.5) {
				if ( user.str_numRepeatedErrorWithInsertionsAvg <= 0.5) {
					if ( user.str_changeInScoreAvg <= 0.2678) {
						values = new int[] { 15,  12,  6,  4,  0,  2,  0,  0,  0,  6 };
					} else {
						values = new int[] { 2,  5,  24,  8,  2,  1,  1,  2,  0,  15 };
					}
				} else {
					if ( puzzle.getUniqueStatementsCount() <= 4.5) {
						values = new int[] { 20,  24,  6,  0,  0,  2,  0,  0,  0,  0 };
					} else {
						values = new int[] { 8,  20,  6,  9,  6,  2,  2,  0,  0,  11 };
					}
				}
			} else {
				if ( user.lastThreeC <= -2.8333) {
					values = new int[] { 11,  8,  10,  0,  2,  5,  0,  0,  0,  9 };
				} else {
					if ( user.notStr_numReducedFirstWrongIndexAvg <= 3.1667) {
						if ( user.lastThree_numAttemptsWithoutOrderingBoxAvg <= 0.1667) {
							if ( user.lastThree_numAttemptsOfoneOrZeroInDoTAvg <= 0.1667) {
								if ( user.notStr_changeInScoreAvg <= 0.2753) {
									values = new int[] { 0,  2,  3,  12,  6,  5,  4,  1,  0,  8 };
								} else {
									values = new int[] { 0,  8,  15,  3,  7,  0,  0,  0,  0,  7 };
								}
							} else {
								if ( user.notStr_nestingDepthAvg <= 1.1667) {
									values = new int[] { 0,  0,  4,  3,  0,  6,  2,  4,  0,  22 };
								} else {
									if ( user.last_postRefPlayScoreAvg <= 0.0955) {
										values = new int[] { 0,  3,  4,  2,  5,  6,  0,  3,  0,  13 };
									} else {
										values = new int[] { 2,  3,  2,  11,  14,  5,  3,  0,  0,  5 };
									}
								}
							}
						} else {
							if ( user.notStr_noRefPlayedBoolean <= 0.8333) {
								values = new int[] { 0,  3,  4,  13,  9,  8,  2,  1,  0,  4 };
							} else {
								values = new int[] { 0,  0,  5,  22,  4,  0,  3,  0,  0,  5 };
							}
						}
					} else {
						values = new int[] { 3,  1,  8,  2,  12,  0,  1,  3,  0,  31 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR2() {
		int[] values;
		if ( puzzle.getStructContent() <= 0.5) {
			if ( user.notStr_noRefPlayedBoolean <= 0.4306) {
				if ( user.str_structContentAvg <= 1.8333) {
					values = new int[] { 5,  21,  7,  1,  6,  0,  0,  0,  1,  6 };
				} else {
					if ( user.str_numReducedFirstWrongIndexAvg <= 1.4167) {
						values = new int[] { 0,  1,  3,  12,  7,  5,  10,  0,  0,  6 };
					} else {
						if ( user.str_structContentAvg <= 2.8333) {
							values = new int[] { 5,  0,  2,  4,  5,  0,  1,  4,  0,  12 };
						} else {
							values = new int[] { 2,  7,  8,  3,  8,  1,  0,  3,  0,  5 };
						}
					}
				}
			} else {
				if ( user.lastThree_uniqueStmtsAvg <= 0.5) {
					values = new int[] { 1,  1,  2,  4,  4,  2,  0,  0,  0,  28 };
				} else {
					if ( user.allT <= -0.5) {
						if ( user.notStr_numConstructsAfterLockAvg <= 5.1667) {
							values = new int[] { 5,  9,  13,  0,  0,  0,  0,  0,  0,  15 };
						} else {
							values = new int[] { 9,  3,  19,  0,  0,  2,  0,  1,  0,  4 };
						}
					} else {
						values = new int[] { 1,  0,  5,  3,  8,  3,  4,  2,  0,  28 };
					}
				}
			}
		} else {
			if ( user.lastThree_cogLoadAvg <= -2.5) {
				if ( user.lastThree_numConstructsAfterLockAvg <= 4.1667) {
					values = new int[] { 11,  22,  6,  0,  0,  2,  0,  0,  0,  0 };
				} else {
					if ( user.lastThreeCbCe <= -1.8333) {
						values = new int[] { 17,  11,  0,  1,  0,  5,  0,  0,  0,  1 };
					} else {
						values = new int[] { 25,  4,  1,  0,  0,  0,  3,  0,  0,  2 };
					}
				}
			} else {
				if ( user.lastThree_noRefPlayedBoolean <= 0.0817) {
					values = new int[] { 1,  22,  4,  9,  1,  1,  0,  0,  0,  0 };
				} else {
					if ( user.allCbCe <= -1.5) {
						if ( user.notStr_changeInConstructScoreAvg <= -0.1667) {
							values = new int[] { 5,  33,  3,  4,  0,  2,  0,  0,  0,  0 };
						} else {
							values = new int[] { 13,  12,  7,  2,  1,  0,  0,  0,  0,  2 };
						}
					} else {
						if ( user.lastThree_numAttemptsOfoneOrZeroInDoTAvg <= 0.5) {
							if ( user.str_numStepsSeparatedNestsAvg <= 2.5) {
								if ( user.str_structContentAvg <= 3.5) {
									if ( user.str_TCntAvg <= 0.1667) {
										if ( user.last_CCntAvg <= 4.5) {
											values = new int[] { 0,  6,  8,  7,  4,  1,  0,  0,  0,  2 };
										} else {
											values = new int[] { 0,  4,  19,  6,  0,  3,  0,  2,  0,  4 };
										}
									} else {
										values = new int[] { 6,  3,  11,  2,  9,  1,  0,  0,  0,  2 };
									}
								} else {
									values = new int[] { 3,  6,  5,  15,  1,  1,  0,  0,  0,  3 };
								}
							} else {
								values = new int[] { 10,  8,  3,  4,  0,  0,  0,  2,  0,  2 };
							}
						} else {
							if ( user.str_postRefPlayScoreAvg <= 0.2068) {
								if ( user.lastThreeTbOe <= 2.1667) {
									values = new int[] { 6,  2,  1,  9,  4,  3,  0,  0,  0,  7 };
								} else {
									values = new int[] { 4,  3,  2,  3,  15,  2,  3,  0,  0,  3 };
								}
							} else {
								values = new int[] { 3,  4,  1,  7,  2,  13,  2,  1,  0,  1 };
							}
						}
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR3() {
		int[] values;
		if ( user.lastThreeT <= -1.8333) {
			if ( puzzle.getStructContent() <= 0.5) {
				if ( user.lastThree_numReducedFirstWrongIndexAvg <= 1.5) {
					values = new int[] { 4,  10,  8,  2,  3,  1,  0,  1,  0,  5 };
				} else {
					values = new int[] { 8,  14,  2,  1,  0,  0,  0,  0,  0,  10 };
				}
			} else {
				if ( user.lastThree_noRefPlayedBoolean <= 0.3071) {
					values = new int[] { 17,  12,  3,  3,  0,  2,  1,  0,  0,  2 };
				} else {
					if ( user.lastThreeTbCe <= -2.1667) {
						values = new int[] { 19,  8,  5,  0,  0,  0,  0,  0,  0,  0 };
					} else {
						values = new int[] { 6,  32,  8,  1,  1,  0,  0,  0,  0,  1 };
					}
				}
			}
		} else {
			if ( user.allTbOe <= -1.5) {
				if ( user.lastThreeT <= 1.5) {
					if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 25.5) {
						if ( user.notStr_changeInScoreAvg <= 0.2808) {
							values = new int[] { 2,  15,  5,  6,  1,  1,  2,  0,  0,  0 };
						} else {
							values = new int[] { 14,  21,  5,  0,  1,  0,  0,  2,  0,  4 };
						}
					} else {
						values = new int[] { 10,  9,  8,  3,  4,  3,  0,  0,  0,  7 };
					}
				} else {
					values = new int[] { 19,  6,  6,  0,  1,  2,  0,  0,  0,  2 };
				}
			} else {
				if ( user.allTbCe <= -0.5) {
					if ( user.allCbCe <= -0.5) {
						values = new int[] { 8,  23,  7,  2,  3,  1,  1,  0,  0,  4 };
					} else {
						values = new int[] { 2,  8,  34,  1,  0,  0,  0,  0,  0,  3 };
					}
				} else {
					if ( user.notStr_noRefPlayedBoolean <= 0.9673) {
						if ( user.notStr_numConstructsAfterLockAvg <= 5.5) {
							if ( user.notStr_numStmtsAfterLockAvg <= 0.1667) {
								if ( user.last_numStepsSeparatedNestsAvg <= 0.5) {
									values = new int[] { 2,  4,  3,  4,  1,  5,  0,  0,  0,  3 };
								} else {
									values = new int[] { 0,  3,  9,  0,  1,  2,  1,  1,  0,  15 };
								}
							} else {
								if ( puzzle.getStructContent() <= 0.5) {
									if ( user.str_numAttemptsAvg <= 8.8333) {
										values = new int[] { 1,  0,  2,  3,  8,  3,  10,  0,  0,  5 };
									} else {
										values = new int[] { 2,  2,  5,  6,  2,  3,  2,  2,  0,  10 };
									}
								} else {
									if ( user.last_CCntAvg <= 5.5) {
										values = new int[] { 7,  4,  9,  13,  6,  0,  0,  2,  0,  2 };
									} else {
										values = new int[] { 2,  12,  2,  4,  2,  1,  4,  0,  0,  2 };
									}
								}
							}
						} else {
							if ( user.lastThree_changeInScoreAvg <= 0.3596) {
								values = new int[] { 4,  7,  4,  12,  7,  6,  0,  2,  1,  7 };
							} else {
								values = new int[] { 2,  4,  3,  3,  28,  8,  1,  0,  0,  11 };
							}
						}
					} else {
						if ( user.notStr_CCntAvg <= 5.1667) {
							values = new int[] { 1,  1,  4,  16,  5,  0,  6,  1,  0,  14 };
						} else {
							values = new int[] { 2,  0,  13,  15,  1,  4,  1,  0,  0,  2 };
						}
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR4() {
		int[] values;
		if ( user.lastThreeT <= -1.1667) {
			if ( puzzle.getUniqueStatementsCount() <= 7.5) {
				if ( user.str_noRefPlayedBoolean <= 0.0726) {
					if ( user.lastThree_CCntAvg <= 5.5) {
						values = new int[] { 5,  20,  2,  0,  1,  1,  0,  0,  0,  0 };
					} else {
						values = new int[] { 9,  17,  5,  0,  1,  1,  0,  0,  0,  1 };
					}
				} else {
					if ( user.str_numMoveSameStmtConsecutivelyAvg <= 3.5) {
						values = new int[] { 21,  10,  14,  0,  0,  0,  0,  0,  0,  0 };
					} else {
						values = new int[] { 14,  20,  0,  0,  1,  0,  0,  3,  0,  2 };
					}
				}
			} else {
				if ( user.str_numStepsDecCorrectInOrderingBoxAvg <= 20.5) {
					values = new int[] { 5,  14,  9,  6,  3,  0,  0,  0,  0,  1 };
				} else {
					values = new int[] { 2,  2,  12,  2,  1,  1,  0,  1,  0,  14 };
				}
			}
		} else {
			if ( user.allC <= -1.5) {
				if ( user.lastThree_numStepsSeparatedNestsAvg <= 0.1667) {
					values = new int[] { 16,  29,  11,  2,  1,  0,  0,  0,  0,  0 };
				} else {
					if ( user.notStr_numAttemptsOfoneOrZeroInDoTAvg <= 0.1667) {
						if ( user.lastThree_cogLoadAvg <= -1.1667) {
							values = new int[] { 4,  17,  8,  1,  0,  3,  0,  0,  0,  1 };
						} else {
							values = new int[] { 3,  10,  8,  13,  5,  2,  2,  0,  0,  13 };
						}
					} else {
						values = new int[] { 21,  6,  13,  5,  3,  7,  2,  0,  0,  6 };
					}
				}
			} else {
				if ( user.lastThree_numAttemptsConstructErrorsAvg <= 3.1667) {
					if ( user.lastThree_cogLoadAvg <= -1.1667) {
						if ( user.notStr_numStmtsAfterLockAvg <= 0.5) {
							values = new int[] { 4,  16,  5,  4,  7,  1,  0,  0,  0,  3 };
						} else {
							values = new int[] { 12,  4,  5,  3,  1,  3,  0,  2,  0,  12 };
						}
					} else {
						if ( puzzle.getNumStmtsAfterLock() <= 6.5) {
							if ( user.last_numAttemptsAvg <= 2.5) {
								values = new int[] { 2,  1,  22,  9,  10,  2,  2,  0,  0,  5 };
							} else {
								if ( user.all_cogLoad <= -0.3308) {
									values = new int[] { 0,  0,  3,  18,  2,  0,  5,  1,  0,  0 };
								} else {
									values = new int[] { 7,  0,  4,  8,  9,  10,  0,  0,  2,  3 };
								}
							}
						} else {
							if ( user.lastThree_numStmtsAfterLockAvg <= 0.5) {
								values = new int[] { 2,  5,  13,  9,  7,  4,  5,  1,  0,  6 };
							} else {
								values = new int[] { 0,  3,  1,  9,  6,  4,  12,  2,  0,  22 };
							}
						}
					}
				} else {
					if ( user.lastThree_changeInScoreAvg <= 0.3465) {
						values = new int[] { 1,  5,  1,  0,  5,  0,  0,  6,  0,  23 };
					} else {
						values = new int[] { 6,  12,  3,  6,  4,  2,  0,  0,  0,  9 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR5() {
		int[] values;
		if ( user.notStr_numAttemptsAvg <= 2.5) {
			if ( user.last_changeInScoreAvg <= 0.0333) {
				if ( user.notStr_postRefPlayScoreAvg <= 0.466) {
					if ( puzzle.getUniqueStatementsCount() <= 4.5) {
						values = new int[] { 10,  12,  13,  1,  0,  0,  0,  0,  0,  0 };
					} else {
						if ( user.all_cogLoad <= -1.1039) {
							values = new int[] { 7,  13,  11,  1,  1,  0,  0,  0,  0,  3 };
						} else {
							values = new int[] { 1,  3,  12,  4,  10,  1,  0,  0,  0,  2 };
						}
					}
				} else {
					values = new int[] { 7,  5,  4,  5,  1,  1,  3,  0,  0,  11 };
				}
			} else {
				if ( user.str_numMoveSameStmtConsecutivelyAvg <= 1.5) {
					values = new int[] { 0,  28,  3,  3,  0,  0,  1,  0,  0,  2 };
				} else {
					if ( user.last_numStepsDecCorrectInOrderingBoxAvg <= 20.5) {
						values = new int[] { 2,  5,  8,  2,  2,  2,  2,  0,  0,  5 };
					} else {
						values = new int[] { 2,  6,  0,  8,  1,  0,  3,  1,  0,  7 };
					}
				}
			}
		} else {
			if ( user.all_cogLoad <= -0.8809) {
				if ( user.notStr_postRefPlayScoreAvg <= 0.171) {
					if ( user.notStr_postRefPlayScoreAvg <= 0.0616) {
						values = new int[] { 20,  4,  0,  1,  2,  3,  0,  0,  0,  2 };
					} else {
						values = new int[] { 18,  10,  7,  6,  0,  1,  2,  0,  0,  1 };
					}
				} else {
					if ( user.notStr_numMoveSameStmtConsecutivelyAvg <= 2.8333) {
						if ( puzzle.getUniqueStatementsCount() <= 4.5) {
							values = new int[] { 24,  13,  14,  1,  2,  0,  0,  0,  0,  0 };
						} else {
							if ( user.str_uniqueStmtsAvg <= 0.4167) {
								values = new int[] { 3,  20,  14,  3,  9,  1,  2,  1,  0,  5 };
							} else {
								values = new int[] { 5,  10,  1,  0,  3,  12,  0,  1,  0,  1 };
							}
						}
					} else {
						values = new int[] { 11,  32,  2,  2,  3,  2,  0,  0,  0,  0 };
					}
				}
			} else {
				if ( user.lastThree_CbCeCntAvg <= 0.1667) {
					if ( user.notStr_numConstructsAfterLockAvg <= 3.5) {
						values = new int[] { 3,  2,  7,  2,  6,  11,  2,  0,  0,  4 };
					} else {
						if ( user.notStr_cogLoadAvg <= -0.5) {
							if ( user.last_numMoveSameStmtConsecutivelyAvg <= 2.5) {
								if ( user.str_numAttemptsWithoutOrderingBoxAvg <= 0.1667) {
									if ( user.notStr_structContentAvg <= 2.1667) {
										values = new int[] { 2,  1,  6,  4,  6,  1,  0,  0,  0,  15 };
									} else {
										values = new int[] { 0,  3,  5,  14,  6,  0,  0,  0,  0,  7 };
									}
								} else {
									values = new int[] { 0,  0,  0,  17,  3,  1,  1,  1,  0,  13 };
								}
							} else {
								values = new int[] { 1,  1,  2,  3,  7,  0,  0,  0,  0,  27 };
							}
						} else {
							values = new int[] { 4,  3,  10,  8,  19,  11,  2,  3,  0,  8 };
						}
					}
				} else {
					if ( user.last_numReducedFirstWrongIndexAvg <= 1.5) {
						values = new int[] { 4,  4,  20,  7,  2,  0,  0,  0,  0,  1 };
					} else {
						values = new int[] { 8,  3,  6,  13,  2,  0,  0,  0,  0,  3 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR6() {
		int[] values;
		if ( user.lastThreeTbOe <= -2.5) {
			if ( user.lastThree_cogLoadAvg <= -3.1667) {
				if ( user.str_numCorrectedFirstWrongIndexAvg <= 0.5) {
					values = new int[] { 23,  5,  0,  0,  0,  2,  0,  1,  0,  1 };
				} else {
					values = new int[] { 8,  8,  5,  1,  0,  1,  0,  0,  0,  6 };
				}
			} else {
				if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 22.1667) {
					values = new int[] { 3,  38,  5,  5,  0,  0,  0,  0,  0,  2 };
				} else {
					values = new int[] { 8,  15,  2,  2,  3,  0,  0,  0,  0,  5 };
				}
			}
		} else {
			if ( user.allTbCe <= -0.5) {
				if ( user.str_cogLoadAvg <= 4.1667) {
					if ( user.str_countsOfPlayPuzConsecutivelyAvg <= 1.8333) {
						values = new int[] { 4,  19,  4,  0,  0,  1,  0,  0,  0,  1 };
					} else {
						values = new int[] { 12,  7,  5,  2,  1,  2,  0,  0,  0,  1 };
					}
				} else {
					if ( user.str_nestingDepthAvg <= 2.5833) {
						if ( user.lastThree_changeInConstructScoreAvg <= -0.1667) {
							values = new int[] { 2,  8,  8,  1,  0,  2,  1,  0,  0,  10 };
						} else {
							values = new int[] { 2,  3,  24,  0,  2,  0,  0,  0,  0,  9 };
						}
					} else {
						values = new int[] { 11,  9,  4,  1,  5,  0,  0,  0,  0,  1 };
					}
				}
			} else {
				if ( user.str_cogLoadAvg <= 3.1667) {
					if ( user.last_changeInScoreAvg <= 0.5907) {
						values = new int[] { 0,  4,  9,  6,  1,  1,  1,  2,  0,  10 };
					} else {
						values = new int[] { 0,  0,  1,  25,  3,  7,  1,  0,  0,  3 };
					}
				} else {
					if ( user.last_numAttemptsConstructErrorsAvg <= 2.5) {
						if ( user.last_cogLoadAvg <= -1.5) {
							if ( user.str_TCntAvg <= 0.1667) {
								values = new int[] { 5,  28,  6,  3,  3,  0,  1,  3,  0,  3 };
							} else {
								if ( user.lastThree_numCorrectedFirstWrongIndexAvg <= 0.1667) {
									values = new int[] { 10,  9,  23,  5,  2,  1,  1,  0,  0,  1 };
								} else {
									values = new int[] { 23,  13,  6,  5,  1,  0,  0,  0,  0,  1 };
								}
							}
						} else {
							if ( user.allC <= -1.5) {
								values = new int[] { 12,  2,  5,  4,  2,  4,  0,  0,  0,  0 };
							} else {
								if ( user.last_noRefPlayedBoolean <= 0.0767) {
									values = new int[] { 0,  2,  6,  6,  5,  10,  2,  1,  0,  19 };
								} else {
									if ( user.str_changeInConstructScoreAvg <= 0.1667) {
										if ( user.lastThree_CCntAvg <= 5.8333) {
											values = new int[] { 2,  0,  5,  16,  3,  1,  3,  2,  2,  3 };
										} else {
											values = new int[] { 3,  5,  2,  5,  4,  7,  1,  1,  0,  5 };
										}
									} else {
										values = new int[] { 0,  2,  5,  5,  14,  2,  1,  2,  0,  1 };
									}
								}
							}
						}
					} else {
						if ( puzzle.getNumStmtsInLock() <= 1.5) {
							if ( user.notStr_numReducedFirstWrongIndexAvg <= 2.1667) {
								values = new int[] { 2,  3,  1,  9,  4,  4,  0,  1,  0,  13 };
							} else {
								values = new int[] { 0,  8,  0,  2,  2,  0,  0,  0,  0,  28 };
							}
						} else {
							values = new int[] { 2,  1,  4,  4,  16,  2,  5,  2,  0,  1 };
						}
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR7() {
		int[] values;
		if ( user.last_cogLoadAvg <= -1.5) {
			if ( user.notStr_numAttemptsAvg <= 2.8333) {
				if ( user.str_numStepsSeparatedNestsAvg <= 2.4167) {
					if ( puzzle.getUniqueStatementsCount() <= 6.5) {
						if ( user.str_numConstructsInLockAvg <= 0.5833) {
							values = new int[] { 4,  13,  9,  0,  2,  0,  0,  0,  0,  2 };
						} else {
							values = new int[] { 7,  4,  24,  0,  0,  0,  0,  0,  0,  6 };
						}
					} else {
						values = new int[] { 4,  5,  13,  10,  5,  5,  1,  0,  0,  14 };
					}
				} else {
					values = new int[] { 5,  19,  6,  6,  0,  0,  0,  0,  0,  1 };
				}
			} else {
				if ( user.lastThreeCbTe <= -2.5) {
					values = new int[] { 23,  10,  4,  4,  0,  0,  0,  0,  0,  4 };
				} else {
					if ( user.notStr_numStepsAvg <= 0.1667) {
						if ( user.str_noRefPlayedBoolean <= 0.091) {
							values = new int[] { 4,  35,  1,  1,  0,  0,  0,  0,  0,  4 };
						} else {
							if ( puzzle.getNumConstructsInLock() <= 0.5) {
								if ( user.last_countsOfPlayPuzConsecutivelyAvg <= 0.5) {
									values = new int[] { 5,  24,  3,  1,  4,  3,  0,  0,  0,  0 };
								} else {
									values = new int[] { 14,  15,  8,  6,  0,  2,  0,  2,  0,  5 };
								}
							} else {
								values = new int[] { 13,  11,  8,  8,  0,  0,  2,  3,  0,  4 };
							}
						}
					} else {
						values = new int[] { 11,  9,  16,  0,  0,  3,  1,  1,  0,  0 };
					}
				}
			}
		} else {
			if ( user.notStr_nestingDepthAvg <= 2.1667) {
				if ( puzzle.getStructContent() <= 0.5) {
					if ( user.lastThree_cogLoadAvg <= 1.8333) {
						if ( user.last_numStmtsAfterLockAvg <= 0.5) {
							values = new int[] { 0,  1,  5,  3,  12,  10,  3,  1,  0,  13 };
						} else {
							values = new int[] { 4,  0,  2,  10,  3,  1,  3,  1,  0,  10 };
						}
					} else {
						values = new int[] { 2,  1,  5,  2,  2,  0,  0,  4,  0,  25 };
					}
				} else {
					if ( user.notStr_changeInScoreAvg <= 0.4682) {
						if ( user.last_countsOfPlayPuzConsecutivelyAvg <= 1.5) {
							values = new int[] { 5,  4,  3,  16,  3,  3,  0,  0,  0,  3 };
						} else {
							values = new int[] { 4,  14,  5,  9,  0,  0,  0,  0,  0,  5 };
						}
					} else {
						if ( user.lastThree_constructReverseUsageAvg <= 0.5) {
							values = new int[] { 4,  2,  1,  6,  5,  3,  5,  0,  0,  12 };
						} else {
							values = new int[] { 9,  0,  4,  6,  4,  7,  2,  1,  0,  5 };
						}
					}
				}
			} else {
				if ( user.str_numCorrectButNotPlayedAvg <= 0.8333) {
					values = new int[] { 0,  3,  21,  4,  4,  2,  0,  0,  0,  7 };
				} else {
					if ( user.lastThreeCbTe <= -0.5) {
						values = new int[] { 6,  9,  5,  0,  5,  2,  0,  2,  0,  1 };
					} else {
						values = new int[] { 4,  4,  2,  19,  14,  4,  3,  0,  0,  3 };
					}
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR8() {
		int[] values;
		if ( user.lastThreeTbOe <= -2.5) {
			if ( user.last_cogLoadAvg <= -3.5) {
				if ( user.lastThreeCbCe <= -2.1667) {
					values = new int[] { 32,  2,  1,  0,  0,  0,  0,  0,  0,  0 };
				} else {
					values = new int[] { 15,  17,  1,  0,  0,  5,  0,  2,  0,  2 };
				}
			} else {
				if ( user.str_numCorrectedFirstWrongIndexAvg <= 0.5833) {
					values = new int[] { 2,  41,  2,  1,  0,  1,  0,  0,  0,  6 };
				} else {
					values = new int[] { 13,  10,  6,  8,  0,  1,  0,  0,  0,  3 };
				}
			}
		} else {
			if ( puzzle.getNumStmtsAfterLock() <= 7.5) {
				if ( user.allC <= -2.5) {
					if ( user.lastThree_noRefPlayedBoolean <= 0.378) {
						values = new int[] { 16,  10,  0,  1,  2,  2,  0,  0,  0,  0 };
					} else {
						values = new int[] { 31,  3,  4,  1,  1,  1,  0,  0,  0,  1 };
					}
				} else {
					if ( user.str_numStmtsAfterLockAvg <= 0.1667) {
						if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 27.5) {
							if ( user.str_numCorrectButNotPlayedAvg <= 0.8333) {
								values = new int[] { 3,  14,  8,  6,  1,  2,  2,  0,  0,  4 };
							} else {
								if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
									values = new int[] { 10,  1,  17,  2,  0,  2,  0,  0,  0,  3 };
								} else {
									values = new int[] { 1,  7,  17,  4,  6,  2,  4,  0,  0,  4 };
								}
							}
						} else {
							values = new int[] { 5,  31,  10,  4,  1,  3,  0,  0,  0,  4 };
						}
					} else {
						if ( puzzle.getUnfamiliarMethodsCount() <= 1.5) {
							values = new int[] { 16,  7,  27,  5,  4,  0,  0,  0,  0,  1 };
						} else {
							if ( user.lastThree_numAttemptsOfdoTogetherRearrangementsAvg <= 0.1667) {
								if ( user.str_nestingDepthAvg <= 1.8333) {
									if ( user.notStr_numAttemptsAvg <= 3.8333) {
										values = new int[] { 0,  1,  1,  3,  3,  3,  0,  0,  0,  19 };
									} else {
										values = new int[] { 3,  2,  5,  5,  6,  7,  2,  0,  1,  9 };
									}
								} else {
									if ( user.last_changeInScoreAvg <= 0.3798) {
										values = new int[] { 2,  1,  9,  7,  4,  3,  0,  2,  0,  10 };
									} else {
										values = new int[] { 2,  0,  5,  17,  4,  1,  1,  0,  0,  0 };
									}
								}
							} else {
								values = new int[] { 2,  7,  9,  2,  15,  0,  2,  0,  0,  2 };
							}
						}
					}
				}
			} else {
				if ( user.allCbCe <= 1.5) {
					if ( user.str_noRefPlayedBoolean <= 0.4553) {
						if ( user.lastThree_numStepsDecCorrectInOrderingBoxAvg <= 37.1667) {
							values = new int[] { 6,  8,  5,  4,  2,  7,  4,  2,  0,  16 };
						} else {
							values = new int[] { 2,  20,  3,  5,  2,  1,  0,  3,  0,  5 };
						}
					} else {
						values = new int[] { 1,  3,  10,  3,  3,  2,  7,  1,  0,  10 };
					}
				} else {
					values = new int[] { 0,  0,  2,  7,  1,  4,  0,  1,  0,  25 };
				}
			}
		}
		return findMaxIndex(values);
	}

	private int TR9() {
		int[] values;
		if ( user.allCbCe <= -1.5) {
			if ( user.notStr_cogLoadAvg <= -3.1667) {
				if ( user.lastThree_numStmtsAfterLockAvg <= 0.5) {
					values = new int[] { 24,  4,  1,  0,  2,  1,  0,  0,  0,  1 };
				} else {
					values = new int[] { 16,  10,  5,  0,  0,  0,  0,  0,  0,  2 };
				}
			} else {
				if ( user.lastThreeCbCe <= -2.8333) {
					if ( user.all_cogLoad <= -1.3714) {
						values = new int[] { 12,  15,  11,  0,  0,  0,  0,  0,  0,  1 };
					} else {
						values = new int[] { 7,  5,  4,  1,  1,  5,  1,  0,  0,  10 };
					}
				} else {
					if ( user.last_noRefPlayedBoolean <= 0.4641) {
						values = new int[] { 1,  31,  4,  5,  0,  3,  1,  0,  0,  6 };
					} else {
						values = new int[] { 1,  28,  5,  0,  3,  0,  0,  0,  0,  0 };
					}
				}
			}
		} else {
			if ( user.str_noRefPlayedBoolean <= 0.0446) {
				values = new int[] { 7,  20,  0,  0,  0,  2,  0,  0,  0,  4 };
			} else {
				if ( user.notStr_uniqueStmtsAvg <= 1.5) {
					if ( user.allTbOe <= -2.5) {
						values = new int[] { 30,  10,  2,  4,  0,  3,  0,  0,  0,  5 };
					} else {
						if ( user.lastThreeT <= -0.5) {
							if ( user.notStr_numMoveSameStmtConsecutivelyAvg <= 1.5) {
								if ( user.notStr_numStepsDecCorrectInOrderingBoxAvg <= 17.1667) {
									values = new int[] { 3,  8,  18,  4,  2,  0,  0,  0,  0,  5 };
								} else {
									values = new int[] { 1,  27,  8,  8,  3,  1,  3,  0,  0,  6 };
								}
							} else {
								values = new int[] { 12,  6,  7,  10,  7,  5,  0,  0,  0,  4 };
							}
						} else {
							if ( user.all_cogLoad <= 0.2478) {
								if ( puzzle.getNumConstructsAfterLock() <= 1.5) {
									values = new int[] { 10,  5,  12,  11,  0,  2,  0,  0,  0,  1 };
								} else {
									if ( user.lastThree_numPlaySameSetAvg <= 1.1667) {
										if ( user.lastThreeTbCe <= 0.5) {
											if ( user.str_noRefPlayedBoolean <= 0.4061) {
												values = new int[] { 7,  9,  2,  6,  13,  5,  1,  0,  0,  19 };
											} else {
												values = new int[] { 0,  1,  20,  5,  3,  2,  0,  0,  0,  11 };
											}
										} else {
											if ( user.last_countsOfPlayPuzConsecutivelyAvg <= 1.5) {
												values = new int[] { 4,  6,  4,  2,  19,  1,  3,  9,  0,  5 };
											} else {
												values = new int[] { 2,  2,  2,  18,  8,  1,  8,  2,  0,  1 };
											}
										}
									} else {
										values = new int[] { 0,  4,  12,  3,  0,  2,  0,  0,  0,  6 };
									}
								}
							} else {
								values = new int[] { 0,  3,  8,  30,  4,  3,  0,  2,  0,  12 };
							}
						}
					}
				} else {
					values = new int[] { 2,  1,  2,  2,  13,  3,  1,  1,  1,  15 };
				}
			}
		}
		return findMaxIndex(values);
	}

}