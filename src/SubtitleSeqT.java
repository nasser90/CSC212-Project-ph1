
public class SubtitleSeqT implements SubtitleSeq {
	
	List<Subtitle> Subtitles;
	
	public SubtitleSeqT(){
		Subtitles = new LinkedList<Subtitle>();
	}

	public void addSubtitle(Subtitle st) {
		if(!Subtitles.full())
			Subtitles.insert(st);
	}

	public List<Subtitle> getSubtitles() {
		return Subtitles;
	}

	///////////
	public Subtitle getSubtitle(Time time) {
		int startT = 0;
		int endT = 0;
		if(!Subtitles.empty()){
			Subtitles.findFirst();
			
			while(!Subtitles.last()){
				if(Subtitles.retrieve().getStartTime().getHH() <= time.getHH()){
					if(Subtitles.retrieve().getStartTime().getHH() == time.getHH()){
						if(Subtitles.retrieve().getStartTime().getMM() <= time.getMM()){
							if(Subtitles.retrieve().getStartTime().getMM() == time.getMM()){
								if(Subtitles.retrieve().getStartTime().getSS() <= time.getSS()){
									if(Subtitles.retrieve().getStartTime().getSS() == time.getSS()){
										if(Subtitles.retrieve().getStartTime().getMS() <= time.getMS()){
											if(Subtitles.retrieve().getStartTime().getMS() == time.getMS()){
												startT = 1;
											}
										}
									}else
										startT = 1;
								}
							}else
								startT = 1;
						}
					}else
						startT = 1;
				}
				
				if(Subtitles.retrieve().getEndTime().getHH() >= time.getHH()){
					if(Subtitles.retrieve().getEndTime().getHH() == time.getHH()){
						if(Subtitles.retrieve().getEndTime().getMM() >= time.getMM()){
							if(Subtitles.retrieve().getEndTime().getMM() == time.getMM()){
								if(Subtitles.retrieve().getEndTime().getSS() >= time.getSS()){
									if(Subtitles.retrieve().getEndTime().getSS() == time.getSS()){
										if(Subtitles.retrieve().getEndTime().getMS() >= time.getMS()){
											if(Subtitles.retrieve().getEndTime().getMS() == time.getMS()){
												endT = 1;
											}
										}
									}else
										endT = 1;
								}
							}else
								endT = 1;
						}
					}else
						endT = 1;
				}
				if(startT == 1 && endT == 1)
					return Subtitles.retrieve();
				Subtitles.findNext();
			}
			
			// Begin for the last element
			if(Subtitles.retrieve().getStartTime().getHH() <= time.getHH()){
				if(Subtitles.retrieve().getStartTime().getHH() == time.getHH()){
					if(Subtitles.retrieve().getStartTime().getMM() <= time.getMM()){
						if(Subtitles.retrieve().getStartTime().getMM() == time.getMM()){
							if(Subtitles.retrieve().getStartTime().getSS() <= time.getSS()){
								if(Subtitles.retrieve().getStartTime().getSS() == time.getSS()){
									if(Subtitles.retrieve().getStartTime().getMS() <= time.getMS()){
										if(Subtitles.retrieve().getStartTime().getMS() == time.getMS()){
											startT = 1;
										}
									}
								}else
									startT = 1;
							}
						}else
							startT = 1;
					}
				}else
					startT = 1;
			}
			
			if(Subtitles.retrieve().getEndTime().getHH() >= time.getHH()){
				if(Subtitles.retrieve().getEndTime().getHH() == time.getHH()){
					if(Subtitles.retrieve().getEndTime().getMM() >= time.getMM()){
						if(Subtitles.retrieve().getEndTime().getMM() == time.getMM()){
							if(Subtitles.retrieve().getEndTime().getSS() >= time.getSS()){
								if(Subtitles.retrieve().getEndTime().getSS() == time.getSS()){
									if(Subtitles.retrieve().getEndTime().getMS() >= time.getMS()){
										if(Subtitles.retrieve().getEndTime().getMS() == time.getMS()){
											endT = 1;
										}
									}
								}else
									endT = 1;
							}
						}else
							endT = 1;
					}
				}else
					endT = 1;
			}
			// End of last element
		}
		
		if(startT == 1 && endT == 1)
			return Subtitles.retrieve();
		return null;
	}

	//////////////////
	public List<Subtitle> getSubtitles(Time startTime, Time endTime) {
		LinkedList<Subtitle> l = new LinkedList<>();
		int startT = 0;
		int endT = 0;
		if(!Subtitles.empty()){
			Subtitles.findFirst();
			
			while(!Subtitles.last()){
				startT = 0;
				endT = 0;
				if(Subtitles.retrieve().getStartTime().getHH() >= startTime.getHH()){
					if(Subtitles.retrieve().getStartTime().getHH() == startTime.getHH()){
						if(Subtitles.retrieve().getStartTime().getMM() >= startTime.getMM()){
							if(Subtitles.retrieve().getStartTime().getMM() == startTime.getMM()){
								if(Subtitles.retrieve().getStartTime().getSS() >= startTime.getSS()){
									if(Subtitles.retrieve().getStartTime().getSS() == startTime.getSS()){
										if(Subtitles.retrieve().getStartTime().getMS() >= startTime.getMS()){
											if(Subtitles.retrieve().getStartTime().getMS() == startTime.getMS()){
												startT = 1;
											}
										}
									}else
										startT = 1;
								}
							}else
								startT = 1;
						}
					}else
						startT = 1;
				}
				
				if(Subtitles.retrieve().getStartTime().getHH() <= endTime.getHH()){
					if(Subtitles.retrieve().getStartTime().getHH() == endTime.getHH()){
						if(Subtitles.retrieve().getStartTime().getMM() <= endTime.getMM()){
							if(Subtitles.retrieve().getStartTime().getMM() == endTime.getMM()){
								if(Subtitles.retrieve().getStartTime().getSS() <= endTime.getSS()){
									if(Subtitles.retrieve().getStartTime().getSS() == endTime.getSS()){
										if(Subtitles.retrieve().getStartTime().getMS() <= endTime.getMS()){
											if(Subtitles.retrieve().getStartTime().getMS() == endTime.getMS()){
												startT = 1;
											}
										}
									}else
										startT = 1;
								}
							}else
								startT = 1;
						}
					}else
						startT = 1;
				}
				if(startT == 1 && endT == 1 &&!l.full())
					l.insert(Subtitles.retrieve());
				
				Subtitles.findNext();
			}
			// Begin for the last element
			startT = 0;
			endT = 0;
			if(Subtitles.retrieve().getStartTime().getHH() >= startTime.getHH()){
				if(Subtitles.retrieve().getStartTime().getHH() == startTime.getHH()){
					if(Subtitles.retrieve().getStartTime().getMM() >= startTime.getMM()){
						if(Subtitles.retrieve().getStartTime().getMM() == startTime.getMM()){
							if(Subtitles.retrieve().getStartTime().getSS() >= startTime.getSS()){
								if(Subtitles.retrieve().getStartTime().getSS() == startTime.getSS()){
									if(Subtitles.retrieve().getStartTime().getMS() >= startTime.getMS()){
										if(Subtitles.retrieve().getStartTime().getMS() == startTime.getMS()){
											startT = 1;
										}
									}
								}else
									startT = 1;
							}
						}else
							startT = 1;
					}
				}else
					startT = 1;
			}
			
			if(Subtitles.retrieve().getStartTime().getHH() <= endTime.getHH()){
				if(Subtitles.retrieve().getStartTime().getHH() == endTime.getHH()){
					if(Subtitles.retrieve().getStartTime().getMM() <= endTime.getMM()){
						if(Subtitles.retrieve().getStartTime().getMM() == endTime.getMM()){
							if(Subtitles.retrieve().getStartTime().getSS() <= endTime.getSS()){
								if(Subtitles.retrieve().getStartTime().getSS() == endTime.getSS()){
									if(Subtitles.retrieve().getStartTime().getMS() <= endTime.getMS()){
										if(Subtitles.retrieve().getStartTime().getMS() == endTime.getMS()){
											startT = 1;
										}
									}
								}else
									startT = 1;
							}
						}else
							startT = 1;
					}
				}else
					startT = 1;
			}
			if(startT == 1 && endT == 1 &&!l.full())
				l.insert(Subtitles.retrieve());
			// End of last element
		}
		
		return l;
	}

	
	public List<Subtitle> getSubtitles(String str) {
		LinkedList<Subtitle> l = new LinkedList<>();
		
		if(!Subtitles.empty()){
			Subtitles.findFirst();
			
			while(!Subtitles.last()){
				if(Subtitles.retrieve().getText().contains(str))
					if(!l.full())
						l.insert(Subtitles.retrieve());
				Subtitles.findNext();
			}
			
			if(Subtitles.retrieve().getText().contains(str))
				if(!l.full())
					l.insert(Subtitles.retrieve());
		}
		
		
		return l;
	}

	
	public void remove(String str) {
		if(!Subtitles.empty()){
			Subtitles.findFirst();
			
			while(!Subtitles.last()){
				if(Subtitles.retrieve().getText().contains(str)){
					if(!Subtitles.empty())
						Subtitles.remove();
				}else
					Subtitles.findNext();
			}
			
			if(Subtitles.retrieve().getText().contains(str))
				if(!Subtitles.empty())
					Subtitles.remove();
		}
		
	}

	
	public void replace(String str1, String str2) {
		if(!Subtitles.empty()){
			Subtitles.findFirst();
			
			while(!Subtitles.last()){
				Subtitles.retrieve().setText(Subtitles.retrieve().getText().replaceAll(str1, str2));
				Subtitles.findNext();
			}
			Subtitles.retrieve().setText(Subtitles.retrieve().getText().replaceAll(str1, str2));
		}
		
	}

	
	public void shift(int offset) {
		
		
	}

	
	public void cut(Time startTime, Time endTime) {
		// TODO Auto-generated method stub
		
	}

}
